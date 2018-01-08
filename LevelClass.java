import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class LevelClass {
   protected JFrame mainFrame;   
   protected JLabel statusLabel1;
   protected JLabel statusLabel2;
   protected JLabel statusLabel3;
   protected JPanel controlPanel;
   String letters_already_guessed="";
   String guessed_answer="";
   String correct_letters_guessed="";
   int counter=0;//for the hangman game to end,counter is 7
   int level;
   String word,description;
   
   String ans_without_spaces="";
   String ans="";
   String initial_blanks="";
  
   public LevelClass(){
      prepareGUI();
   }
   
   private void prepareGUI(){
      mainFrame = new JFrame("HANGMAN ");
      
      mainFrame.setSize(500,500);
      /*here GridLayout(4,1) means
       * 4 rows and 1 column
       * so if ur using one more statusLabel then make it (5,1)
       */
      mainFrame.setLayout(new GridLayout(4,1));
      
      //on pressing the close button of the frame
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      
              
      statusLabel1 = new JLabel("",JLabel.CENTER);    
      statusLabel1.setSize(100,100);
      statusLabel2 = new JLabel("",JLabel.CENTER);    
      statusLabel2.setSize(100,100);
      statusLabel3 = new JLabel("",JLabel.CENTER);    
      statusLabel3.setSize(100,100);
      

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel1);
      mainFrame.add(statusLabel2);
      mainFrame.add(statusLabel3);
      mainFrame.setVisible(true);  
      //mainFrame.pack();
   }
  
   public JButton CreateJButton(String letter) {
	   JButton letterButton = new JButton( letter );
	   letterButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           letterButton.setBackground(Color.BLACK);
	  		   letterButton.setForeground(Color.PINK);
	        	 receive(letter.toLowerCase());
	        	
	        	 statusLabel1.setText("Your last guess was: " + letter);
	         }          
	      });
	   //you can add the button to the control panel here only if u want
	   //controlPanel.add(letterButton);
	   return letterButton;
   }
  public String[] CreateButton(String word_got){
	   
	   
	   String[] letters={"Q","W","E","R","T","Y","U","I","O","P",
			   "A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
	   //instead of writing 26 times ,we use a for loop
	 
	   return  letters;
	
   }
  
   protected LevelClassLisnter listener_complete;
	public void setOnCompleteListener(LevelClassLisnter listener)
	{
		listener_complete = listener;
		//listner.onLevelComplete(level);
	}
	protected LevelClassLisnter listener_failed;
	public void setOnFailedListener(LevelClassLisnter listener)
	{
		listener_failed = listener;
		
	}
   public void StartGame(String word_got,String descr_got,int level){
      
	   //since two variable names are the same,use this.level
	   this.level=level;
	   word=word_got;
	  int size=word.length();
	  
	  String letters[]=CreateButton(word_got);
	  for(int i=0;i<letters.length;i++){
		   JButton button = CreateJButton(letters[i]);
		   //button.setBackground(Color.BLACK);
		   //button.setForeground(Color.PINK);
		   controlPanel.add(button);
	   }
	   /*String[] letters={"Q","W","E","R","T","Y","U","I","O","P",
			   "A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M"};
	   //instead of writing 26 times ,we use a for loop
	   for(int i=0;i<26;i++){
		   JButton button = CreateJButton(letters[i]);
		   //button.setBackground(Color.BLACK);
		   //button.setForeground(Color.PINK);
		   controlPanel.add(button);
	   }
	   
		*/
	 mainFrame.setVisible(true);
       
     for(int i=0;i<size;i++){
    	 initial_blanks+=" "+ "_";
    	 }
     statusLabel2.setText(initial_blanks);
     statusLabel3.setText("Description:" + descr_got);
      
      
   }
   public void receive(String letter){
	   
	   char[] answer=new char[word.length()];
	   
	   if(letters_already_guessed.contains(letter)){
		   JOptionPane.showMessageDialog(null, "Already guessed");
		  
	   }
	   else if(word.contains(letter)){
		  correct_letters_guessed+=letter;
		  
		  letters_already_guessed+=letter;
		  
		  //initially the answer array has only blanks
		  for(int j=0;j<word.length();j++)
			  answer[j]='_';
		  for(int i=0;i<correct_letters_guessed.length();i++){
			  for(int j=0;j<word.length();j++){
				  //only if the word contains those letters,then answer[j] is that letter 
				  if(correct_letters_guessed.charAt(i)==word.charAt(j)){
					  answer[j]=word.charAt(j);
				  }
				  
			  }
				  
		  }
		  
		  for(int j=0;j<word.length();j++){
			  
			  ans+=" "+answer[j];
			  ans_without_spaces+=answer[j];
			  
		  }
		  statusLabel2.setText(ans);
		  //if you want to display after every correct guess,uncoment this
		  //JOptionPane.showMessageDialog(null, "This guess is right");
		  if(ans_without_spaces.equals(word)){
			  JOptionPane.showMessageDialog(null, "You passed level:"+level);
			  mainFrame.setVisible(false);
			  
			  listener_complete.onLevelComplete(level);
			  /*level+=1;
			  if(level<=3){
				  //since its a static func,access using classname.methodname(parameters)
			  Game.PlayGameLevel(level);
			  }
			  else{
				  System.exit(0);
			  }*/
			  
		  }
		  ans="";
		  ans_without_spaces="";
		  System.out.println();
		  for(int j=0;j<word.length();j++){
			  answer[j]=' ';
		  }
		  
		  
	  }
	   else {
		   
		   if(counter==7){
			   
			   JOptionPane.showMessageDialog(null, "YOU LOSE AND THE WORD WAS "+word.toUpperCase());
			   mainFrame.setVisible(false);
			   //ReplayLevelGui gui_rep=new ReplayLevelGui();
			   //gui_rep.setTitle("CONFIRM TO EXIT?");
			   //gui_rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			   //gui_rep.setVisible(true);
			   //gui_rep.setSize(200,300);
			   listener_failed.onLevelFailed(level);
			   //System.exit(0);
		   }
		   else{
			   letters_already_guessed+=letter;
			   counter++;
			   JOptionPane.showMessageDialog(null, "GUESSES LEFT:"+(7-counter));
		   }
	   }
	
   	}
   }

