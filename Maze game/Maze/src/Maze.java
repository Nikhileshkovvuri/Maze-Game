import java.awt.Component;
import javax.swing.JFrame;

/**
 * Runs the Maze game.
 */
public class Maze
{
    public Maze(final int lvl) {
        final JFrame f = new JFrame();
        f.setTitle("Maze Game");
        f.add(new Board(lvl));
        f.setSize(500, 520);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
    }
}
