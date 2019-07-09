public class GuessTheMovie {

    public static void main(String[] args) {

        Game game = new Game();

        // generating the random movie name and its corresponding notation with underscores.
        game.generateMovie();


        // you have 10 guess chances.
        while (game.getWrongAnswers() < 10) {
            game.makeGuess();

            // break the while loop if you completely guessed the word.
            if (game.getHiddenMovie().indexOf('_') == -1) {
                System.out.println("Well done. You win the game. The movie is ' " + game.getChosenMovie() + "'");
                break;
            }
        }

        // 10 wrong answers mean that you lost.
        if (game.getWrongAnswers() == 10) {
            System.out.println("Sorry. U lost the game.");
            System.out.println("The movie was " + game.getChosenMovie());
        }
    }

}
