import java.io.File;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.Scanner;

public class Map
{

/**
 * A Map class that generates a full game map represented by
 * a 2D array of characters.
 */
    private Scanner m;
    private String[] Map;
    private Image wall;
    private Image gameOver;
    private Image road;
    private Image finish;
    
    public Map(final int lvl) {
        this.Map = new String[15];
        ImageIcon img = new ImageIcon("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Res\\images\\walls.png");
        this.wall = img.getImage();
        img = new ImageIcon("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Res\\images\\Road.png");
        this.road = img.getImage();
        img = new ImageIcon("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Res\\images\\fairy-tail-2-icon.png");
        this.finish = img.getImage();
        img = new ImageIcon("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Res\\images\\Victory.png");
        this.gameOver = img.getImage();
        this.openFile(lvl);
        this.readFile();
        this.closeFile();
    }
    
    public Image getWall() {
        return this.wall;
    }
    
    public Image getRoad() {
        return this.road;
    }
    
    public Image getFinish() {
        return this.finish;
    }
    
    public Image getGameOver() {
        return this.gameOver;
    }
    
    public String getMap(final int x, final int y) {
        final String index = this.Map[y].substring(x, x + 1);
        return index;
    }
    
    public void openFile(final int lvl) {
        try {
            this.m = new Scanner(new File("C:\\Users\\Nick\\eclipse-workspace\\Maze\\Map" + lvl + ".txt"));
        }
        catch (Exception e) {
            System.out.println("error loading map");
        }
    }
    
    public void readFile() {
        while (this.m.hasNext()) {
            for (int i = 0; i < 15; ++i) {
                this.Map[i] = this.m.next();
            }
        }
    }
    
    public void closeFile() {
        this.m.close();
    }
}
