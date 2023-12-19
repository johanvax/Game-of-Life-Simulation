import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gameoflife extends JFrame implements KeyListener {

    public static final String title = "Game of Life - Simulation";
    private Game game;
    private JLabel squares[][];
    private int gridDim1;
    private int gridDim2;

    public Gameoflife(int gridDim1, int gridDim2) {
        this.gridDim1 = gridDim1;
        this.gridDim2 = gridDim2;
        game = new Game(gridDim1, gridDim2);
        setTitle(title);
        setSize(800, 800);
        setLayout(new GridLayout(gridDim1, gridDim2));
        addKeyListener(this);
        setFocusable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        squares = new JLabel[gridDim1][gridDim2];

    }

    public void start() {
        render(game.getGrid());
        for (int i = 0; i < gridDim1; i++) {
            for (int j = 0; j < gridDim2; j++) {
                add(squares[i][j]);
            }
        }
        setVisible(true);

    }

    private void render(int[][] grid) {
        for (int i = 0; i < gridDim1; i++) {
            for (int j = 0; j < gridDim2; j++) {
                squares[i][j] = new JLabel();
                squares[i][j].setOpaque(true);
                if (grid[i][j] == 0) {
                    squares[i][j].setBackground(Color.blue);
                } else {
                    squares[i][j].setBackground(Color.orange);
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
                    squares[i][j].setBackground(Color.blue);
                } else {
                    squares[i][j].setBackground(Color.orange);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            boardUpdate();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            boardUpdate();
        }
    }

}
