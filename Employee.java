import java.util.*;
import java.sql.*;

public class EmpProject {
	private static String url="jdbc:mysql://localhost:3306/mits";
	private static String user="root";
	private static String password="root";
	private static Scanner s=new Scanner(System.in);
	public static void main(String[] args) {
			while(true) {
				System.out.println("1.......Add");
				System.out.println("2.......display");
				System.out.println("3.......update");
				System.out.println("4.......delete");
				System.out.println("5.......column");
				System.out.println("6.......exit");
				int e=s.nextInt();
				s.next();
			switch(e) {
			case 1:
				add();
				break;
			case 2:
				display();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				column();
				break;
			case 6:
				exit();
				break;
			default:
				System.out.println("Nothing");
			}
		}
	}
		public static void add(){
			 try(Connection conn=DriverManager.getConnection(url, user, password)){
		            Scanner scnr=new Scanner(System.in);
		            System.out.print("Enter Emp_Id: ");
		            int id=scnr.nextInt();
		            scnr.nextLine();
		            System.out.print("Enter Emp_Name: ");
		            String name=scnr.nextLine();
		            System.out.print("Enter Emp_Role: ");
		            String role=scnr.nextLine();
		            System.out.print("Enter Hire_Date(yyyy-mm-dd): ");
		            String hire_date=scnr.nextLine();
		            scnr.nextLine();
		            System.out.print("Enter Salary: ");
		            Double salary=scnr.nextDouble();
		            scnr.nextLine();
		            String s1="insert into Emp6 values("+id+",'"+name+"','"+role+"','"+hire_date+"',"+salary+");";
		            PreparedStatement s=conn.prepareStatement(s1);
		            int n=s.executeUpdate(s1);
		            System.out.println("Row inserted Successfully "+n);
		            scnr.close();
		            conn.close();
		        }catch(SQLException e){
		            e.printStackTrace(); 
		        }
		}
		public static void display() {
			try(Connection conn=DriverManager.getConnection(url, user, password)){
	            System.out.println("Database connected Successfully");
	            Statement stmt=conn.createStatement(
	                ResultSet.TYPE_SCROLL_INSENSITIVE, 
	                ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs=stmt.executeQuery("select * from Emp2;");
	            System.out.println("Id   "+"Name      "+"Role     "+"Hire_Date "+"Salary   ");
	            System.out.println("--------------------------------------------------------");
	            while (rs.next()) {
	                System.out.println(rs.getInt("emp_id")+"  "+rs.getString("emp_name")+"  "+rs.getString("emp_job_role")+"  "+rs.getDate("hire_date")+"  "+rs.getDouble("emp_salary"));
	            }
	            conn.close();
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
		public static void update() {
			 Scanner scnr=new Scanner(System.in);
		        System.out.print("Enter emp_id");
		        int id=scnr.nextInt();
		        System.out.print("Enter salary:");
		        Double updated=scnr.nextDouble();
		        try(Connection conn=DriverManager.getConnection(url, user, password)){
		            Statement s=conn.createStatement();
		            String s1="update Emp6 set salary="+updated+"where emp_id="+id+";";
		            int n=s.executeUpdate(s1);
		            System.out.println("Updated salary "+n);
		            scnr.close();
		            conn.close();
		        }catch(SQLException e){
		            e.printStackTrace();
		        }
		    }
		public static void delete() {
			  Scanner scnr=new Scanner(System.in);
		        System.out.println("Enter emp_id");
		        int id=scnr.nextInt();
		        try(Connection conn=DriverManager.getConnection(url, user, password)){
		            Statement s=conn.createStatement();
		            String s1="delete from Emp6 where emp_id="+id+";";
		            int n=s.executeUpdate(s1);
		            System.out.println("Deleted Emp with id "+id+" "+n);
		            scnr.close();
		            conn.close();
		        }catch(SQLException e){
		            e.printStackTrace();
		        }
		    }
		public static void column() {
			 Scanner scnr=new Scanner(System.in);
		        System.out.print("Enter Column Name:");
		        String col=scnr.nextLine();
		        try(Connection conn=DriverManager.getConnection(url, user, password)){
		            Statement s=conn.createStatement();
		            String s1="select "+col+" from Emp6;";
		            ResultSet rs=s.executeQuery(s1);
		            System.out.println(" "+col+" ");
		            System.out.println("------------");
		            while(rs.next()){
		                System.out.println(rs.getObject(""+col+""));
		            }
		            scnr.close();
		            conn.close();
		        }catch(SQLException e){
		            e.printStackTrace();
		        }
		}
		public static void exit() {
			 Scanner scnr=new Scanner(System.in);
		      System.out.println("1.Add Student");
		      System.out.println("2.Display Emp Details");
		      System.out.println("3.Update Salary");
		      System.out.println("4.Delete Employee");
		      System.out.println("5.Display Column Details");
		      System.out.println("6.Exit");
		      System.out.print("Enter choice: ");
		      int ch=scnr.nextInt();
		      while(ch!=6){
		        EmpProject e=new EmpProject();
		        switch(ch){
		            case 1:e.add();break;
		            case 2:e.display();break;
		            case 3:e.update();break;
		            case 4:e.delete();break;
		            case 5:e.column();break;
		        }
		        System.out.println("1.Add Student");
		        System.out.println("2.Display Emp Details");
		        System.out.println("3.Update Salary");
		        System.out.println("4.Delete Employee");
		        System.out.println("5.Display Column Details");
		        System.out.println("6.Exit");
		        System.out.print("Enter choice: ");
		        ch=scnr.nextInt();
		      }
		      scnr.close();
		}

}
