public class GuessTheMovie {

    public static void main(String[] args) {

        Game game = new Game();


        game.generateMovie();

        while (game.getWrongAnswers() < 10) {
            game.makeGuess();
            if (game.getHiddenMovie().indexOf('_') == -1) {
                System.out.println("Well done. You win the game. The movie is ' " + game.getChosenMovie() + "'");
                break;
            }
        }
        if (game.getWrongAnswers() == 10) {
            System.out.println("Sorry. U lost the game.");
            System.out.println("The movie was " + game.getChosenMovie());
        }
    }

}
