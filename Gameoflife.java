import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gameoflife implements KeyListener {

    public static final String title = "Game of Life Simulation - Hold enter or press space";
    private Game game;
    private JLabel squares[][];
    private int gridDim1;
    private int gridDim2;
    private JFrame frame;

    private Color alive;
    private Color dead;

    private boolean enterPressed = false;

    public Gameoflife(int gridDim1, int gridDim2, Color alive, Color dead, int probability) {
        this.gridDim1 = gridDim1;
        this.gridDim2 = gridDim2;
        this.alive = alive;
        this.dead = dead;
        game = new Game(gridDim1, gridDim2, probability);
        squares = new JLabel[gridDim1][gridDim2];
        frame = new JFrame();
    }

    public void start() {
        setup();
        render(game.getGrid());
        for (int i = 0; i < gridDim1; i++) {
            for (int j = 0; j < gridDim2; j++) {
                frame.add(squares[i][j]);
            }
        }
        frame.setVisible(true);
    }

    private void setup() {
        frame.setTitle(title);
        frame.setSize(gridDim2*10, gridDim1*10);
        frame.setLayout(new GridLayout(gridDim1, gridDim2));
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.init();
    }

    private void render(int[][] grid) {
        for (int i = 0; i < gridDim1; i++) {
            for (int j = 0; j < gridDim2; j++) {
                squares[i][j] = new JLabel();
                squares[i][j].setOpaque(true);
                if (grid[i][j] == 0) {
                    squares[i][j].setBackground(dead);
                } else {
                    squares[i][j].setBackground(alive);
                }

                squares[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }
    }

    private void boardUpdate() {
        int[][] grid = game.generateNext();
        for (int i = 0; i < gridDim1; i++) {
            for (int j = 0; j < gridDim2; j++) {
                if (grid[i][j] == 0) {
                    squares[i][j].setBackground(dead);
                } else {
                    squares[i][j].setBackground(alive);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        enterPressed = true;
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            boardUpdate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (enterPressed) {
            boardUpdate();
            enterPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            boardUpdate();
        }
    }

}
