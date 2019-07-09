import java.util.*;
import java.io.*;

public class GuessTheMovie {

    public static void main(String[] args) throws FileNotFoundException {
        // creating the arraylist of movie names.
        File file = new File("movies.txt");
        Scanner sc = new Scanner(file);
        int totLength = 0;
        ArrayList<String> movieList = new ArrayList<String>();

        while (sc.hasNextLine()) {
            movieList.add(sc.nextLine());
        }


        // selecting the random movie.
        int randInd = (int)((Math.random() * movieList.size()));
        String chosenMovie = movieList.get(randInd);

        String holderMovie = chosenMovie.replaceAll("[a-zA-Z]", "_");
        System.out.println(holderMovie);
        System.out.println(chosenMovie);

        int wrongAnswers = 0;

        Scanner in = new Scanner(System.in);

        while (wrongAnswers < 10){
            System.out.println("Your are guessing: " + holderMovie);
            System.out.println("You have guessed ( " + wrongAnswers + " ) wrong letters:");
            System.out.println("Please guess a letter: ");
            char letter = in.nextLine().toCharArray()[0];
            char[] holderMovieChar = holderMovie.toCharArray();

            //System.out.println(holderMovie.replaceAll("_",letter));

            int index = chosenMovie.indexOf(letter);
            if (index == -1){
                wrongAnswers++;
                continue;
            }

            while (index >= 0) {
                holderMovieChar[index] = letter;
                index = chosenMovie.indexOf(letter, index + 1);
            }
            holderMovie = String.valueOf(holderMovieChar);


            if(holderMovie.indexOf('_') == -1){
                System.out.println("Well done. You win the game. The movie is " + chosenMovie);
                break;

            }
        }
        if(wrongAnswers == 10){
        System.out.println("Sorry. U lost the game.");
        System.out.println("The movie was " + chosenMovie);
        }
    }

}
