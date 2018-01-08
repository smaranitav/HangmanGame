import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ReplayLevelGui extends JFrame  {

	  
	  //private JLabel label2;
	  private JButton replayButton;
	  private JButton exitButton;
	  private int level;
	  
	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  
	  ReplayLevelGui(int level){
		  this.level=level;
		  setLayout(new FlowLayout());
		  
		  replayButton=new JButton("REPLAY LEVEL");
		  replayButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 Game obj_to_replay=new Game();
		        	 obj_to_replay.PlayGameLevel(level);
		        	 setVisible(false);
		         }          
		      });
		  
		  exitButton=new JButton("EXIT");
		  exitButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	 setVisible(false);
		        	 System.exit(0);
		         }          
		      });
		  add(replayButton);
		  add(exitButton);
	  }
	  
		
}
