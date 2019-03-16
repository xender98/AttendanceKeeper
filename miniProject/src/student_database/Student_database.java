
package student_database;
import java.sql.*;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
/*
data base:

Roll_no:  Student_name  email_id  Date  Present 
_________________________________________________
|	|	       |         |     |        | 
|       |              |         |     |        |
|       |              |         |     |        |
_________________________________________________
*/

/**
 *
 * @author admin
 */
public class Student_database {

    public Connection c = null;
      public PreparedStatement stmt = null;
    public Student_database()
    {
     try {
       
         //For connections to Data Base
           Class.forName("com.mysql.jdbc.Driver");
       
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");  

        
           c.setAutoCommit(false);
       
           String selectSQL = "SELECT * FROM student_info;";
           stmt= c.prepareStatement(selectSQL);
         }
      catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
    }
    
    
    public boolean check_roll(int roll) throws SQLException
    {
        String selectSQL = "SELECT * FROM attandance;";
        stmt= c.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
                 
                int roll_no=rs.getInt("ROLL_NO");
               
                if(roll_no==roll)
                {
                  return false;
                }
        }
        return true;
    }
     //check he or she is Nirma student or not
    public boolean check_user(int roll,String name) throws Exception{


            String selectSQL = "SELECT * FROM student_info;";
            this.stmt= this.c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                int roll_no=rs.getInt("ROLL_NO");
                String Name=rs.getString("NAME");

                if(roll_no==roll&name.equals(Name))
                {
                  return true;
                }



           }
             rs.close();

            return false;


    }
    public ArrayList<Integer> all_roll() throws Exception{

        ArrayList<Integer> roll=new ArrayList<Integer>();
        String selectSQL = "SELECT * FROM student_info;";
        this.stmt= this.c.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            roll.add(rs.getInt("ROLL_NO"));



        }
        rs.close();
        return roll;



    }
    public ArrayList<String> all_name() throws Exception{

        ArrayList<String> name=new ArrayList<String>();
        String selectSQL = "SELECT * FROM student_info;";
        this.stmt= this.c.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            name.add(rs.getString("NAME"));



        }
        rs.close();
        return name;
    }
    // cnt_present of student call by its roll no
    public ArrayList<String> cnt_present(int roll) throws Exception{
      
            String selectSQL = "SELECT * FROM attandance;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<String> arr=new ArrayList<String>();
            
            while ( rs.next() ) {
                  
                int roll_no=rs.getInt("ROLL_NO");
                
                if(roll_no==roll)
                {
                    arr.add(rs.getString("DATE"));
                }
         
        
                // System.out.println( "roll_no = " + roll_no);
           }
           
      rs.close();
         return arr;
    }
    
    // check student present on current day or not
    public boolean check(int roll,String date) throws Exception{
            String selectSQL = "SELECT * FROM attandance;";
            stmt= c.prepareStatement(selectSQL);
            
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                
                int roll_no=rs.getInt("ROLL_NO");
                String s=rs.getString("DATE");
            
                String s1=s.substring(0,10);
                // System.out.println( "roll_no = " + roll_no+" is equal:"+(roll_no==roll&s1.equals(date)));  
         
                if(roll_no==roll&s1.equals(date))
                {
                    rs.close();
                    return true;
                }
         
        
        
           }
           
      rs.close();
         return false;
      
    }
    
    // give name and email of user by it's roll number
    public String[] get_user(int roll) throws Exception{
    
            String s[]=new String[]{};
            String selectSQL = "SELECT * FROM student_info;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                  
                int roll_no=rs.getInt("ROLL_NO");
                
                if(roll_no==roll)
                {
                  s=new String[]{rs.getString("NAME"),rs.getString("EMAIL_ADDRESS")};
                  break;
                  
                }
         
        
                // System.out.println( "OUTPUT " + s);
           }
           
      rs.close();
         return s;
    }
    
    public boolean check_user_input(String name,String pass,int roll) throws Exception
    {
        ///System.out.println(name+" "+pass+" "+roll);
        String selectSQL = "SELECT * FROM student_info;";
        stmt= c.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        while ( rs.next() ) {

            int roll_no=rs.getInt("ROLL_NO");
            String n=rs.getString("NAME");
            String p=rs.getString("Password");

           /// System.out.println("*"+n+" "+p+" "+roll_no);
            if(roll_no==roll && name.equals(n) && pass.equals(p))
            {
                ///System.out.println("login:"+true);
                rs.close();
                return true;
            }
            // System.out.println( "OUTPUT " + s);
       }
        
        ///System.out.println("login:"+false);
           
      rs.close();
      return false;
    }
    
    public boolean check_user_input(String pass,int roll) throws Exception
    {
        String selectSQL = "SELECT * FROM student_info;";
        stmt= c.prepareStatement(selectSQL);
        ResultSet rs = stmt.executeQuery();
        while ( rs.next() ) {

            int roll_no=rs.getInt("ROLL_NO");
            String p=rs.getString("Password");

            if(roll_no==roll && pass.equals(p))
            {
                ///System.out.println("login:"+true);
                rs.close();
                return true;
            }
            // System.out.println( "OUTPUT " + s);
       }
        
        ///System.out.println("login:"+false);
           
      rs.close();
      return false;
    }
    
    // give name of the student
     public String getname(int roll) throws Exception{
    
            String s=new String();
            String selectSQL = "SELECT * FROM student_info;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                  
                int roll_no=rs.getInt("ROLL_NO");
                
                if(roll_no==roll)
                {
                  s=rs.getString("NAME");
                  break;
                  
                }
         
        
                //System.out.println( "OUTPUT " + s);
           }
           
      rs.close();
         return s;
    }
     
     public void delete_student(int roll) throws Exception{
     
            String s=new String();
            String selectSQL = "DELETE FROM student_info where ROLL_NO="+roll+" ;";
            System.out.println(selectSQL);
            stmt= c.prepareStatement(selectSQL);
                  
            boolean i=stmt.execute();
            System.out.println(i+" records Updated");
            selectSQL = "DELETE FROM ATTANDANCE where ROLL_NO="+roll+" ;";
            stmt= c.prepareStatement(selectSQL);
            System.out.println(selectSQL);      
           boolean  j = stmt.execute();
            System.out.println(j+" records Updated");

           
     }
     // give mail of student
     
      public String getemail(int roll) throws Exception{
          
    
            String s=new String();
            String selectSQL = "SELECT * FROM student_info;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while ( rs.next() ) {
                  
                int roll_no=rs.getInt("ROLL_NO");
                
                if(roll_no==roll)
                {
                  s=rs.getString("EMAIL_ADDRESS");
                  break;
                  
                }
         
        
                // System.out.println( "OUTPUT " + s);
           }
           
      rs.close();
         return s;
    }
      // This function on request send mail to student for get his password back
   public String forgot_pass(String email) throws Exception{
    
            String pass="";
            String selectSQL = "SELECT * FROM student_info;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                String Email=rs.getString("EMAIL_ADDRESS");
                int roll=rs.getInt("ROLL_NO");
                if(email.equals(Email))
                {
                       pass=rs.getString("Password");
                       break;
                
                }
         
        
         
           }
          
             rs.close();
            return pass;
    }
    // insert_by_login method mark attendance of student to database by login page
  public void insert_by_login(int roll,String password)throws Exception {
         
           
           DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   Date date = new Date();
           String s=String.valueOf(sdf.format(date));
           String s1=s.substring(0,10);
           System.out.println("Insert by login cnt is:"+cnt_present(roll));
            if(!this.check(roll,s1))
            {
                

                System.out.println(date);
                System.out.println(sdf.format(date));
                

                String email=this.getemail(roll);

                String pass=this.forgot_pass(email);

               this.stmt=null;
               this.stmt= this.c.prepareStatement("INSERT INTO ATTANDANCE(ROLL_NO,PRESENT,DATE) VALUES (?,?,?);");
                if(pass.equals(password))
                {
                  
                  stmt.setInt(1,roll);
                  stmt.setString(2,"PRESENT");
                  stmt.setString(3,String.valueOf(sdf.format(date))); 

                  int i=stmt.executeUpdate();  

                  System.out.println(i+" records inserted");  
                }
                else
                {
                           System.out.println("Insert_by_login:***********Enter valid password************");
                }

            }
            else
            {
            System.out.println("Insert_by_login:**********You already present OR YOU NOT SIGNUP*************");
            }
    }
  //user Authentications
  boolean user_auth(int Roll,String password)throws Exception{
    
            
            String selectSQL = "SELECT * FROM student_info;";
            stmt= c.prepareStatement(selectSQL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                 
                
                String pass =rs.getString("Password");
                int roll=rs.getInt("ROLL_NO");
                if(roll==Roll && pass.equals(password))
                {
                       return true;
                
                }
         
        
         
           }
          
            rs.close();
            return false;
    }

    // update user details
    public void update_profile(int roll,String name,String email)throws Exception {

          System.out.println(" records Updated");  
      //  if(this.user_auth(roll,password))
           {
         //String query="UPDATE student_info SET NAME=\""+name+"\" WHERE ROLL_NO="+roll+";";
              stmt= c.prepareStatement("UPDATE student_info SET NAME=?,EMAIL_ADDRESS=? WHERE ROLL_NO=?;");
              
              stmt.setString(1,name);
              stmt.setString(2,email);
              System.out.println(name+" records Updated");  
             
             // stmt.setString(1,email);
              stmt.setInt(3,roll);
            
             
         stmt.executeUpdate();  
         System.out.println(" records Updated");  
            }
       
    }
   // for change password
    public void update_password(int roll,String name, String oldPass,String new_pass)throws Exception {

       
        if(this.user_auth(roll,oldPass))
        {
             stmt= c.prepareStatement("UPDATE student_info SET Password=? WHERE ROLL_NO=?;");
  
             stmt.setString(1,new_pass);
                         
             stmt.setInt(2,roll);
 
             int i=stmt.executeUpdate();  
             System.out.println(i+" records Updated");  
        
        
          }
        else
        {
                   System.out.println("Update_password:***********Enter valid password************");
        }
         
       
    }
    // mark attendance by face reco. 
  public void insert_by_face(int roll)throws Exception {
           System.out.println("Insert_by_face:**********Trying to Mark present by face*************");
           DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	   Date date = new Date();
           String s=String.valueOf(sdf.format(date));
           String s1=s.substring(0,10);
           System.out.println("Insert_by_face:cnt is:"+cnt_present(roll));
       if(!this.check(roll,s1))
        {
           this.stmt= this.c.prepareStatement("INSERT INTO ATTANDANCE(ROLL_NO,PRESENT,DATE) VALUES (?,?,?);");
           System.out.println(date);
           System.out.println(sdf.format(date));
           
           stmt.setInt(1,roll);
           stmt.setString(2,"PRESENT");
           stmt.setString(3,String.valueOf(sdf.format(date))); 

             
         int i=stmt.executeUpdate();  
         System.out.println(i+" records inserted");  
        
        
        }
       else
       {
       System.out.println("Insert_by_face:**********You already present*************");
       }
    }
  // for new user
    public boolean singup(String password,int roll,String name,String email)throws Exception {
         
          System.out.println("Signup:****************Try to connect database........************");
          DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
          String s=String.valueOf(sdf.format(date));
          String s1=s.substring(0,10);
          
       if(!this.check_user(roll, name))
       {
          stmt= c.prepareStatement("INSERT INTO student_info(Password,ROLL_NO,NAME,EMAIL_ADDRESS) VALUES (?,?,?,?);");
           
           System.out.println(date);
           System.out.println(sdf.format(date));
          
             stmt.setString(1,password);
             stmt.setInt(2,roll);
             stmt.setString(3,name);
             stmt.setString(4,email);
              int i=stmt.executeUpdate();  
         System.out.println(i+" :----records inserted in sudent info------");
             
          return true;
       }
       else
       {
           System.out.println("Signup:****************You already Singin please go to login************");
           return false;
       }
       
    }
    
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
      Student_database db=new Student_database();
      try {
        
           // String s =db.get_user(23);
            //System.out.println("get_user :  "+s);
            //System.out.println("check_user  "+db.check_user(22,"jaydutt"));
            //db.singup("y42",8,"PATD","__FUCKOFF__@gmail.com");
          //  db.insert_by_login(8,"nskd");
            //db.insert_by_face(22);
         //db.singup("1234",8,"jaydutt","jayduttpatel19@gmail.com");//         String password,int roll,String name,String email)
         //  db.update_profile(10,"jydutt","jaydutt@gmail.com","oia");
           // db.update_password(23,"darshan","jshaa","newpass");
           ArrayList<String> dat=db.get_date("28/03/2018","05/05/2018");
         System.out.println("in main:"+dat);
           db.stmt.close();
            db.c.commit();
            db.c.close();
         
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("---------------Table created successfully");
   }
    
    public ArrayList<String> get_date(String st,String en) throws Exception{
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
  
        ArrayList<String> dates = new ArrayList<String>();

        try {
            Date date1 = myFormat.parse(st);
            Calendar c1 = DateToCalendar(date1);
            Date date2 = myFormat.parse(en);
            Calendar c2 = DateToCalendar(date2);

            while (!areEqualDate(c1, c2)) 
            {
                String s=String.valueOf(c1.getTime());
                String s1=s.substring(0,3);
                
                if(!s1.equals("Sun")&!s1.equals("Sat"))
                {
                    dates.add(myFormat.format(c1.getTimeInMillis()).toString());
                } 
                c1.add(Calendar.DAY_OF_YEAR, 1);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dates);
        return dates;
    }
    
    public static boolean areEqualDate(Calendar c1, Calendar c2) 
    {
        if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) 
            return false; 
        if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) 
            return false; 
        if (c1.get(Calendar.DAY_OF_YEAR) != c2.get(Calendar.DAY_OF_YEAR)) 
            return false; 
        return true;
    }

    public static Calendar DateToCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
    
}
/* for create table use this:
         stmt = c.createStatement();
         stmt = c.prepareStatement("INSERT INTO STUDENT(ID,ROLL_NO,NAME,EMAIL_ADDRESS,PRESENT,DATE) values (?,?,?,?,?,?)");
         String sql = "CREATE TABLE STUDENT" +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " ROLL_NO            INT     NOT NULL, " +
                        " NAME           TEXT    NOT NULL, " +
                        " EMAIL_ADDRESS        CHAR(50), " + 
                        " PRESENT        TEXT    NOT NULL, "+
                        " DATE           TEXT    NOT NULL)"; 
         stmt.executeUpdate(sql);
*/
//CREATE TABLE STUDENT (ID INT PRIMARY KEY NOT NULL,ROLL_NO INT NOT NULL,NAME           TEXT    NOT NULL,EMAIL_ADDRESS        CHAR(50),PRESENT        TEXT    NOT NULL,DATE           TEXT    NOT NULL); 