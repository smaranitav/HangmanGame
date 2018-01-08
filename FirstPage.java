
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame  {

  private ImageIcon backgroundImage;
  private JLabel label1;
  //private JLabel label2;
  private JButton playButton;
  

  // Some code to initialize the background image.
  // Here, we use the constructor to load the image. This
  // can vary depending on the use case of the panel.
  /*protected LevelClassLisnter first_listener;
  public void setFirstListener(LevelClassLisnter listener)
	{
		first_listener = listener;
		//listner.onLevelComplete(level);
	}*/
  FirstPage(){
	  setLayout(new FlowLayout());
	  backgroundImage=new ImageIcon(getClass().getResource("hangman1.jpg"));
	  label1=new JLabel(backgroundImage);
	  playButton=new JButton("play");
	  playButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 Game obj=new Game();
	        	 obj.PlayGameLevel(1);
	        	 //first_listener.onStart(1);
	        	 setVisible(false);
	         }          
	      });
	  add(label1);
	  add(playButton);
	  
  }



 
}