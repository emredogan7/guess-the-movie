import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // fields
    public String chosenMovie = new String();
    public String hiddenMovie = new String();
    private int wrongAnswers = 0;
    public ArrayList<Character> previousLetters = new ArrayList<Character>();

    public void generateMovie() {
        // creating the arrayList of movie names.
        File file = new File("movies.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> movieList = new ArrayList<String>();
        while (sc.hasNextLine()) {
            movieList.add(sc.nextLine());
        }
        // selecting the random movie.
        int randInd = (int) ((Math.random() * movieList.size()));
        String chosenMovie = movieList.get(randInd);
        String hiddenMovie = chosenMovie.replaceAll("[a-zA-Z]", "_");

        this.chosenMovie = chosenMovie;
        this.hiddenMovie = hiddenMovie;
    }

    public void makeGuess() {
        System.out.println("Your are guessing: " + this.hiddenMovie);
        System.out.println("You have guessed ( " + this.wrongAnswers + ") wrong letters:");
        System.out.println("Guess a  letter: ");
        Scanner in = new Scanner(System.in);
        char letter = in.nextLine().toCharArray()[0];

        if (previousLetters.contains(letter))
            ;
        else {
            previousLetters.add(letter);
            char[] hiddenMovieChar = this.hiddenMovie.toCharArray();
            int index = this.chosenMovie.indexOf(letter);
            if (index == -1) {
                this.wrongAnswers++;
            } else {
                while (index >= 0) {
                    hiddenMovieChar[index] = letter;
                    index = this.chosenMovie.indexOf(letter, index + 1);
                }
                this.hiddenMovie = String.valueOf(hiddenMovieChar);
            }
        }
    }

    public int getWrongAnswers() {
        return this.wrongAnswers;
    }

    public String getChosenMovie() {
        return this.chosenMovie;
    }

    public String getHiddenMovie() {
        return this.hiddenMovie;
    }
}
