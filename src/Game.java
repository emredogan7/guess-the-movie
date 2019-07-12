import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class Game {

    // fields
    private String chosenMovie = new String();
    private String hiddenMovie = new String();
    private int wrongAnswers = 0;
    private ArrayList<Character> previousLetters = new ArrayList<>();


    /**
     * choose a movie randomly from movies.txt.
     * Assign chosenMovie and hiddenMovie fields of the object according to the chosen movie.
     */
    public void generateMovie() {
        // creating the arrayList of movie names.
        File file = new File("movies.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> movieList = new ArrayList<>();
        while (sc.hasNextLine()) {
            movieList.add(sc.nextLine());
        }
        // selecting the random movie.
        int randInd = (int) ((Math.random() * movieList.size()));
        String chosenMovie = movieList.get(randInd);
        String hiddenMovie = chosenMovie.replaceAll("\\S", "_");

        this.chosenMovie = chosenMovie;
        this.hiddenMovie = hiddenMovie;
    }


    /**
     * take the input letter as the guess.
     * check whether this letter was tried earlier or not.
     * if not, check whether the letter is valid in the movie name.
     */
    public void makeGuess() {
        out.println("Your are guessing: " + this.hiddenMovie);
        out.println("You have guessed ( " + this.wrongAnswers + ") wrong letters:");
        out.println("Guess a  letter: ");
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
