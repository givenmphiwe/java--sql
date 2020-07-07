
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class poised {

	
	/**
	 * first are the variables
	 * the program will firstly print the menu where user will select one
	 * the try and catch its for when the user enter wrong input
	 * and projects are stored in text file..the try catch its for when user enters wrong input under if statements
	 * then when user has selected the add project ..everything he enters will be stored in text
	 * and other options are not stored in text
	 * 
	 */
	
	public static void main(String[] args) {
		
		String input;
		String name;
		int telephone;
		String emailaddress;
		int projectnumber;
		String projectname;
		String buildingtype;
		String physicaladdress;
		double totalfee;
		double totalpaid;
		String projectdeadline;
		
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Poised stores\n"
					+ "1. Add a project: "
					+ "2. Change due date: "
					+ "3. Change total amount: "
					+ "4. Update contractor's details: "
					+ "5. See all projects that still need to be completed"
					+ "6. Projects that are past due date\n");
			
			System.out.println("Select your  1-4: ");
			input = scanner.nextLine();
		}
		catch (IOException e) {
			System.out.println("please select a valid option");
			
		}
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS info(number int NOT NULL AUTO_INCREMENT,name varchar(255),design varchar(255),address varchar(70),fee varchar(20),paid varchar(20),deadline varchar(20),PRIMARY KEY NUMBER)");
			
			
		   if (input.equals("1")) {
				
				System.out.println("enter project number:");
				String number = scanner.next();
				
				System.out.println("enter project name:");
				String proj = scanner.nextLine();
				
				System.out.println("enter the type of building design:");
				String building = scanner.nextLine();
			
				System.out.println("write the physical address of the building: ");
				String address = scanner.nextLine();
				
				System.out.println("Enter the total fee:");
				String fee = scanner.next();
				
				System.out.println("Enter the total amount paid: ");
				String paid = scanner.next();
				
				System.out.println("write the month the deadline is: ");
				String deadline = scanner.nextLine();
				
				//adding the project info to database
				create.executeUpdate("insert into info values(number,proj,building,address,fee,paid,deadline)");
				
				//getting the users input 
				project building = new project(projectname, projectnumber, buildingtype, physicaladdress, totalfee, totalpaid, projectdeadline);
				System.out.println(building.toString());
				
			}else if(input.equals("2")) {
				System.out.println("Enter the new due date: ");
				projectdeadline = scanner.nextLine();
				
				//calling the project class and toString method
				
				project building = new project(projectdeadline);
				System.out.println(building.toString());
				
			}else if(input.contentEquals("3")) {
				System.out.println("Enter the new total amount: ");
				totalpaid = scanner.nextDouble();
				
				//calling the project class and to string method
				
				project building = new project(totalpaid);
				System.out.println(building.toString());
				
			}else if(input.equals("4")) {
				System.out.println("enter the name: ");
				name = scanner.nextLine();
				
				System.out.println("enter telephone number: ");
				telephone = scanner.nextInt();
				
				System.out.println("enter the emailaddress: ");
				emailaddress = scanner.nextLine();
				
				System.out.println("enter the physical address: ");
				physicaladdress = scanner.nextLine();
				
				personsobject worker = new personsobject(name, telephone, emailaddress, physicaladdress);
				System.out.println(worker.toString);
			}
			else if(input.equals("5")) {
				 
				create.executeUpdate("SELECT *FROM info");

				}
			
		}
		catch (IOException e) {
			System.out.println("let me check for that error!");
		}
			
		

	}

	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.Jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/testdb";
			String username = "hello";
			String password = "your-pass";
			Class.forName( driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("you are online buddy");
			
			
		}catch(Exception e) {
			System.out.println("something is wrong");
			
	
		}
		return null;
	}

}
