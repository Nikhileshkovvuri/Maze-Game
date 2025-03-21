import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener
{

/**
 * A board class that generates a full game board represented by
 * a 2D array of characters.
 */
    private Timer timer;
    private boolean win;
    private Map m;
    private Player p;
    
    public Board(final int lvl) {
        this.win = false;
        this.m = new Map(lvl);
        this.p = new Player();
        this.addKeyListener(new Al());
        this.setFocusable(true);
        (this.timer = new Timer(10, this)).start();
    }
    

    /**
	 * The method repaints the board.
	 */
    public void actionPerformed(final ActionEvent e) {
        if (this.m.getMap(this.p.getTileX(), this.p.getTileY()).equals("f")) {
            this.win = true;
        }
        this.repaint();
    }
    

	/**
	 * Modification of the paint method that correctly paints the 
	 * game board on the canvas with respect to the 2D array of the
	 * maze, scaled accordingly.
	 */
    public void paint(final Graphics g) {
        super.paint(g);
        if (!this.win) {
            for (int y = 0; y < 15; ++y) {
                for (int x = 0; x < 15; ++x) {
                    if (this.m.getMap(x, y).equals("f")) {
                        g.drawImage(this.m.getFinish(), x * 32, y * 32, null);
                    }
                    if (this.m.getMap(x, y).equals("w")) {
                        g.drawImage(this.m.getWall(), x * 32, y * 32, null);
                    }
                    if (this.m.getMap(x, y).equals("r")) {
                        g.drawImage(this.m.getRoad(), x * 32, y * 32, null);
                    }
                }
            }
            g.drawImage(this.p.getPlayer(), this.p.getTileX() * 32, this.p.getTileY() * 32, null);
        }
        if (this.win) {
            g.drawImage(this.m.getGameOver(), 0, 0, null);
        }
    }
    
    public void keyReleased(final KeyEvent e) {
    }
    
    public void keyTyped(final KeyEvent e) {
    }
    
    public class Al extends KeyAdapter
    {
        @Override
        public void keyPressed(final KeyEvent e) {
            final int keycode = e.getKeyCode();
            if (keycode == 87 && !Board.this.m.getMap(Board.this.p.getTileX(), Board.this.p.getTileY() - 1).equals("w")) {
                Board.this.p.move(0, -1);
            }
            if (keycode == 83 && !Board.this.m.getMap(Board.this.p.getTileX(), Board.this.p.getTileY() + 1).equals("w")) {
                Board.this.p.move(0, 1);
            }
            if (keycode == 65 && !Board.this.m.getMap(Board.this.p.getTileX() - 1, Board.this.p.getTileY()).equals("w")) {
                Board.this.p.move(-1, 0);
            }
            if (keycode == 68 && !Board.this.m.getMap(Board.this.p.getTileX() + 1, Board.this.p.getTileY()).equals("w")) {
                Board.this.p.move(1, 0);
            }
        }
    }
}
