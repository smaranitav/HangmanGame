import java.sql.*;
import java.util.*;

public class Database {
	
	public  List<String> connect(int level){
		Connection con1=null;
		String word,description;
		List<String> words_list=new ArrayList<String>();
		List<String> description_list=new ArrayList<String>();
		List<String> words_and_description=new ArrayList<String>();
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/hangmannew", "root", "phosilsplinter04");
            //jus print the statement saying connected, just to make sure it is:
			if (!con1.isClosed())
                System.out.println("Successfully connected to MySQL server...");
            String query="Select * FROM questionbank where level="+level;
            
            Statement stmt=con1.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){
            	word=rs.getString(1);
            	words_list.add(word);
            	description=rs.getString(2);
            	description_list.add(description);
            	//System.out.println(""+word+" "+description);
            }
            //System.out.println("this is "+words_list);
            //System.out.println("this is "+description_list);
            
            
            //selecting a random index within the range of size of each column
            Random rand=new Random();
            int index=rand.nextInt(words_list.size());
            
           
            //System.out.println(" word :"+words_list.get(index));
            //System.out.println(" description :"+description_list.get(index));
            words_and_description.add(words_list.get(index));
            words_and_description.add(description_list.get(index));
            return words_and_description;
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
            return null;
        } finally {
           
            
            try {
                if (con1!= null){
                    con1.close();
                    
                }
            } catch(SQLException e) {}
           
            	
            }
            
        }
}
	
	
	
	
	