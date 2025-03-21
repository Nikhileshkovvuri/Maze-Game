import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.LayoutManager;
import java.awt.Container;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JFrame;

/**
 * A class that sets up the main menu user interface for selecting
 * either to view instructions or play the game.
 */
public class Menu extends JFrame
{
    private JPanel MainMenu;
    public boolean level2;
    
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final Menu frame = new Menu();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
	 *  Constructor for the Menu that adds the title along with
	 *  the two buttons for playing the game and viewing the instructions
	 *  
	 *  One anonymous classes is used to listen for a play game click, 
	 *  in which it will call up the difficulty class.
	 *  
	 *  The second anonymous class listens for a click on the instructions,
	 *  in which it would display the appropriate instructions screen.
	 */
    
    public Menu() {
        this.level2 = false;
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 500, 520);
        (this.MainMenu = new JPanel()).setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.MainMenu);
        this.MainMenu.setLayout(null);
        final JLabel Title = new JLabel("Welcome To Maze illusions of maps");
        Title.setVerticalAlignment(1);
        Title.setFont(new Font("arial", 1, 12));
        Title.setBounds(122, 98, 239, 99);
        this.MainMenu.add(Title);
        final JButton play = new JButton(" Easy ");
        play.setFont(new Font("arial", 1, 11));
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new Maze(1);
            }
        });
        play.setBounds(125, 241, 233, 58);
        this.MainMenu.add(play);
        final JButton button = new JButton("Medium");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new Maze(2);
            }
        });
        button.setFont(new Font("Arial", 1, 11));
        button.setBounds(125, 310, 233, 58);
        this.MainMenu.add(button);
        final JButton button_1 = new JButton("Hard");
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                new Maze(3);
            }
        });
        button_1.setFont(new Font("Arial", 1, 11));
        button_1.setBounds(125, 379, 233, 58);
        this.MainMenu.add(button_1);
    }
}
