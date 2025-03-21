import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * A class that creates all the elements necessary for a player
 * to traverse the maze.
 */

public class Player
{
    private int tileX;
    private int tileY;
    private Image player;
    

	/**
	 * Constructor for the player that will be set on the specified
	 * board. The player will automatically start at the top left 
	 * of the board
	 * @param board The board the player will play on.
	 */
    public Player() {
        final ImageIcon img = new ImageIcon("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Res\\images\\Skull.png");
        this.player = img.getImage();
        this.tileX = 0;
        this.tileY = 0;
    }
    
    public Image getPlayer() {
        return this.player;
    }
    
    public int getTileX() {
        return this.tileX;
    }
    
    public int getTileY() {
        return this.tileY;
    }
    
    public void move(final int dx, final int dy) {
        this.tileX += dx;
        this.tileY += dy;
    }
}
