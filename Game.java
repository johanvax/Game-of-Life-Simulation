import java.util.Random;

public class Game {

    private Random random;
    private int gridDim1;
    private int gridDim2;
    private int[][] grid;
    private int[][] next;
    private int probability;

    public Game(int gridDim1, int gridDim2, int probability) {
        this.random = new Random();
        this.grid = new int[gridDim1][gridDim2];
        this.gridDim1 = gridDim1;
        this.gridDim2 = gridDim2;
        this.probability = probability;
    }

    public void init() {
        for (int i = 0; i < gridDim1; i++) {
            for (int k = 0; k < gridDim2; k++) {
                if (random.nextInt(100) <= probability) {
                    grid[i][k] = 1;
                } else {
                    grid[i][k] = 0;
                }
            }
        }
    }

    public int[][] generateNext() {

        next = new int[gridDim1][gridDim2];

        for (int i = 1; i < gridDim1 - 1; i++) {
            for (int k = 1; k < gridDim2 - 1; k++) {
                int sum = 0;

                sum += grid[i - 1][k - 1];
                sum += grid[i - 1][k];
                sum += grid[i - 1][k + 1];
                sum += grid[i][k - 1];
                sum += grid[i][k + 1];
                sum += grid[i + 1][k - 1];
                sum += grid[i + 1][k];
                sum += grid[i + 1][k + 1];

                if (grid[i][k] == 1) {
                    if (sum > 3 || sum < 2) {
                        next[i][k] = 0;
                    } else {
                        next[i][k] = 1;
                    }
                } else {
                    if (sum == 3) {
                        next[i][k] = 1;
                    } else {
                        next[i][k] = 0;
                    }
                }
            }
        }
        grid = next;
        return next;
    }

    public int[][] getGrid() {
        return grid;
    }
}
