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

        System.out.println(movieList.size());

        // selecting the random movie.
        int randInd = (int)((Math.random() * (movieList.size()+1)));
        String chosenMovie = movieList.get(randInd);

    }
}
