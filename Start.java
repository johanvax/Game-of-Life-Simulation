import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start implements MouseListener{

    Color aliveColor;
    Color deadColor;
    int counter = 0;
    JFrame start;
    String[] args;

    public Start(String[] args) {
        this.args = args;
    }

    public void start_up() {  
        start = new JFrame();
        start.setSize(300, 50);
        start.setTitle("Please choose an alive color");
        start.setLayout(new GridLayout(1, 13));
        JLabel[] squares = new JLabel[13];
        addColors(squares);
        for (int i = 0; i < squares.length; i++) {
            squares[i].setOpaque(true);
            squares[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            squares[i].addMouseListener(this);
            start.add(squares[i]);
        }
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setVisible(true);
    }

    private void begin(String[] args) {
        Gameoflife gameoflife = new Gameoflife(Integer.valueOf(args[0]), Integer.valueOf(args[1]), aliveColor, deadColor);
        gameoflife.start();
    }

    private void addColors(JLabel[] squares) {
        squares[0] = new JLabel();
        squares[0].setBackground(Color.BLACK);

        squares[1] = new JLabel();
        squares[1].setBackground(Color.DARK_GRAY);

        squares[2] = new JLabel();
        squares[2].setBackground(Color.GRAY);

        squares[3] = new JLabel();
        squares[3].setBackground(Color.LIGHT_GRAY);

        squares[4] = new JLabel();
        squares[4].setBackground(Color.BLUE);

        squares[5] = new JLabel();
        squares[5].setBackground(Color.CYAN);

        squares[6] = new JLabel();
        squares[6].setBackground(Color.GREEN);

        squares[7] = new JLabel();
        squares[7].setBackground(Color.MAGENTA);

        squares[8] = new JLabel();
        squares[8].setBackground(Color.ORANGE);

        squares[9] = new JLabel();
        squares[9].setBackground(Color.pink);

        squares[10] = new JLabel();
        squares[10].setBackground(Color.RED);

        squares[11] = new JLabel();
        squares[11].setBackground(Color.YELLOW);

        squares[12] = new JLabel();
        squares[12].setBackground(Color.WHITE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        JLabel pressed = (JLabel) e.getComponent();
        if (counter == 0) {
            aliveColor = pressed.getBackground();
            counter++;
            start.setTitle("Please choose a dead color");
        } else if (counter == 1) {
            deadColor = pressed.getBackground();
            start.setVisible(false);
            begin(args);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
