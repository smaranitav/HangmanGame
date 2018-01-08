import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game implements LevelClassLisnter {
	//static int prev_level=0;
	public  static void main(String[] args){
		 FirstPage gui=new FirstPage();
		 gui.setTitle("HANGMAN");
		 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 gui.setVisible(true);
		 gui.pack();
		 //gui.setFirstListener();
		
	}
	
	/*public void onStart(int level) {
		// TODO Auto-generated method stub
		PlayGameLevel(1);
		
	} */
	public void onLevelComplete(int level){
		//if you did post increment like level++ ,it doesnt work correctly
		PlayGameLevel(++level);
	}
	public void onLevelFailed(int level){
		ReplayLevelGui gui_rep=new ReplayLevelGui(level);
		gui_rep.setTitle("CONFIRM TO EXIT?");
		gui_rep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui_rep.setVisible(true);
		gui_rep.setSize(200,300);
		//PlayGameLevel(level);
	}
	public void PlayGameLevel(int level) {
		String word,desc;
		if(level<4){
			LevelClass obj1=new LevelClass();
			//int curr_level=level;
			
			List<String> words_and_description=new ArrayList<String>();
			//List<String> prev_words_and_description=new ArrayList<String>();
			
			Database db_obj=new Database();
			words_and_description=db_obj.connect(level);
			word=words_and_description.get(0);
			desc=words_and_description.get(1);
			
			/*switch(level){
				
				//case 1:obj1=new LevelClass();
				case 2:obj1=new CustomisedLevelClass();
				case 3:obj1=new CustomisedLevelClass2();
				default:obj1=new LevelClass();
			}
			
		*/
			if(level==2){
				obj1=new CustomisedLevelClass();
			}
			else if(level==3){
				obj1=new CustomisedLevelClass2();
			}
			
		//prev_level+=1;
		obj1.setOnCompleteListener(this);
		obj1.setOnFailedListener(this);
		obj1.StartGame(word,desc,level);
		
	}
	else{
		System.exit(0);
	}


	}	
}
