import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JdbcTest {



	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		class Corona{  
			  String state;  
			  String city;  
			  int male;
			  int female;
			  Corona(String state,String city,int male, int female){  
			   this.state=state;  
			   this.city=city;  
			   this.male=male;
			   this.female=female;
			  }  
			}  
		
		
		Corona d1=new Corona("Tamilnadu","Chennai",60,30);  
		Corona d2=new Corona("Tamilnadu","Coimbatore",25,10);
		Corona d3=new Corona("Ap","Chitoor",15,20);
		Corona d4=new Corona("Ap","Vijayawada",45,31);
		Corona d5=new Corona("Kerala","Cochin",75,45);
		Corona d6=new Corona("Kerala","Wayanad",15,15);
		  //creating arraylist  
		  ArrayList<Corona> al=new ArrayList<Corona>();  
		  al.add(d1);//adding Student class object  
		  al.add(d2);  
		  al.add(d3);  
		  al.add(d4); 
		  al.add(d5); 
		  al.add(d6); 
		
	       
		
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "student" , "student");
			
			System.out.println("Database connection successful!\n");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			 DatabaseMetaData meta = myConn.getMetaData();
			  ResultSet res = meta.getTables(null, null, "Corona", null);
			  if (res.next()) {
				  System.out.println("1. Display Count State wise Total\n" + 
		        			"2. TN Total\n" + 
		        			"3. TN Male Total\n"+"4. TN Female Total\n"+"5. AP Total\n" + 
		        			"6. AP Male Total\n"+"7. AP Female Total\n"+"8. Kerala Total\n" + 
		        			"9. Kerala Male Total\n"+"10. Kerala Female Total\n"+"11. Exit\n"+"Choose your option:");
		        	
		        	String sql2="select sum(male)+sum(female) as Total FROM corona where state='Tamilnadu'" ;
	        		String sql3="select sum(male)+sum(female) as Total FROM corona where state='Ap'" ;
	        		String sql4="select sum(male)+sum(female) as Total FROM corona where state='Kerala'" ;
	        		
	        	boolean flag = true;
	        	while(flag) {
	        		
	        		Scanner scan = new Scanner(System.in);
		        	int num = scan.nextInt();
		        	
		        	switch(num) {
		        	  case 1:
		        		
		        		myRs=myStmt.executeQuery(sql2);
		        		if(myRs.next()){
		        			System.out.println("The Toatal No.of cases in Tamilnadu is:"+ myRs.getString("Total"));
		        			}
		        		myRs=myStmt.executeQuery(sql3);
		        		if(myRs.next()){
		        			System.out.println("The Toatal No.of cases in Ap is:"+ myRs.getString("Total"));
		        			}
		        		myRs=myStmt.executeQuery(sql4);
		        		if(myRs.next()){
		        			System.out.println("The Toatal No.of cases in Kerala is:"+ myRs.getString("Total"));
		        			}
		        		
		        		
		        	    break;
		        	  case 2:
		        		  myRs=myStmt.executeQuery(sql2);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
		        	    
		        	  case 3:
		        		  String sql5="select sum(male) as Total FROM corona where state='Tamilnadu'" ;
		        		  myRs=myStmt.executeQuery(sql5);
			        		if(myRs.next()){
			        			
			        			System.out.println("The Toatal No.of Male cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 4:
		        		  String sql6="select sum(female) as Total FROM corona where state='Tamilnadu'" ;
		        		  myRs=myStmt.executeQuery(sql6);
			        		if(myRs.next()){
			        			
			        			System.out.println("The Toatal No.of Female cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 5:
		        		  myRs=myStmt.executeQuery(sql3);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of cases in Ap is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 6:
		        		  String sql7="select sum(male) as Total FROM corona where state='Ap'" ;
		        		  myRs=myStmt.executeQuery(sql7);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of Male cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 7:
		        		  String sql8="select sum(female) as Total FROM corona where state='Ap'" ;
		        		  myRs=myStmt.executeQuery(sql8);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of Female cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 8:
		        		  myRs=myStmt.executeQuery(sql4);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of cases in Kerala is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 9:
		        		  String sql9="select sum(male) as Total FROM corona where state='Kerala'" ;
		        		  myRs=myStmt.executeQuery(sql9);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of Male cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
	        	    
		        	  case 10:
		        		  String sql10="select sum(male) as Total FROM corona where state='Kerala'" ;
		        		  myRs=myStmt.executeQuery(sql10);
			        		if(myRs.next()){
			        			System.out.println("The Toatal No.of Female cases in Tamilnadu is:"+ myRs.getString("Total"));
			        			}
		        	    break;
		        	    
		        	  case 11:
		        		  System.out.println("You will be exited now");
		        		  flag = false;
		        		  break;
	        	    
		        	    
		        	  default:
		        	    System.out.println("Please check your choice");
		        		  break;
		        	}
	        	}
			  }
			  else {
				  System.out.println("Database is empty, so creating database for you..."); //prints this message if your resultset is empty
		            String sql = "CREATE TABLE `corona` (\n" + 
		            		"  `state` varchar(64) NOT NULL,\n" + 
		            		"  `city` varchar(64) NOT NULL,\n" + 
		            		"  `male` int(11) NOT NULL ,\n" +
		            		"  `female` int(11) NOT NULL\n" + 
		            		")";
		            myStmt.executeUpdate(sql);
		            Iterator itr1=al.iterator();
					 while(itr1.hasNext()){ 
			            	System.out.println("Entering");
			            Corona st=(Corona)itr1.next(); 
			            String sql1 = ("INSERT INTO `corona`(state,city,male,female) VALUE ('"+st.state+"','"+st.city+"','"+st.male+"','"+st.female+"')");
			            myStmt.executeUpdate(sql1);
			            }
					
				  
			  }
			
		
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
