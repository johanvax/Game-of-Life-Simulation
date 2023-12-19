public class Main {
    public static void main(String[] args) {
        Gameoflife gameoflife = new Gameoflife(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        gameoflife.start();

    }
}
