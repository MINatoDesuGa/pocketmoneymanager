//Pocket Money Manager v1.0

import java.io.*;
import java.util.*;
import java.lang.*;

class pmm {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice , p = 0;
		String username = "";
		
		System.out.println("\n			-----Pocket Money Manager------");
		System.out.println("\n1. Create new account");
		System.out.println("2. Open existing account");
		System.out.println("3. Exit");			
		System.out.print("Enter choice number: ");
		choice = Integer.parseInt(br.readLine());
		
		switch(choice) {
			case 1: System.out.println("\n	-----Create new account-----");
					  System.out.print("\n Enter your name: ");
					  String user_name = br.readLine();
					  username = user_name;
					  FileOutputStream out = new FileOutputStream("Data.txt");	
					  byte[] write_data = user_name.getBytes();
					  out.write(write_data);							//Writing to file
					  out.write(32);
					  System.out.print(" Enter your pocket money amount: ");
					  int total_amount = Integer.parseInt(br.readLine());
					  String input_amount = Integer.toString(total_amount);
					  write_data = input_amount.getBytes();
					  out.write(write_data);
					  out.close();
					  System.out.println("\n				Account created!");
					  p = 1;
					  break;
			
			case 2: System.out.println("\n	 -----Account login-------");
					  System.out.print("\n Enter account name: ");
					  user_name = br.readLine();
					  username = user_name;
					  FileInputStream in = new FileInputStream("Data.txt");
					  int x = 0;
					  String name = "";
					  while((x=in.read())!=-1) {
						   if (x > 64 && x < 123)
								name += (char) x;
						   else
	  							break;
					  }
					  in.close();
					  if(user_name.equals(name)) { 
					  		System.out.println("\n----------------------Welcome " + name + "----------------------");
							p = 1;
					  }
				     else {
					  		System.out.println("Account name does not exist\n" + "Exiting.......");
							System.exit(1);
					  }
					  break;
					  
		
			case 3: System.out.println("\nExiting........................");
					  break;
			
			default: System.out.println("\n Invalid choice number"); 		
		}
			int amount;
			String newbal = "";
			do {
				int bal = 0;
				byte[] write_data;
				if(p != 0) {
					FileInputStream in = new FileInputStream("Data.txt");
					int x = 0;
					while((x=in.read())!=-1) {
						if(x > 47 && x < 58)
							bal = bal*10 + (x-48);
					}
				in.close();
				FileOutputStream newout = new FileOutputStream("Data.txt");
				
				System.out.println("Your current balance: " + bal);
				System.out.println("\n 1. Add money");
				System.out.println(" 2. Deduct some amount");
				System.out.println(" 3. Exit");
				System.out.print("\nEnter your choice no. : ");
				choice = Integer.parseInt(br.readLine());
				
				switch(choice) {
					case 1: System.out.print("\nEnter the amount you want to add: ");
							  amount = Integer.parseInt(br.readLine());
							  amount += bal;
							  write_data = username.getBytes();
							  newout.write(write_data);
							  newout.write(32);
				 			  newbal = Integer.toString(amount);
							  write_data = newbal.getBytes();
							  newout.write(write_data);
							  //out.close();
							  System.out.println("Account updated successfully!\n");
							  break;
					case 2: System.out.print("\nEnter the amount you want to deduct: ");
							  amount = Integer.parseInt(br.readLine());
							  amount = bal - amount;
							  write_data = username.getBytes();
							  newout.write(write_data);
							  newout.write(32);
				 			  newbal = Integer.toString(amount);
							  write_data = newbal.getBytes();
							  newout.write(write_data);
							  //out.close();
							  System.out.println("Account updated successfully!\n");
							  break;
					case 3: newbal = Integer.toString(bal);
							  write_data = username.getBytes();
							  newout.write(write_data);
							  newout.write(32);
 							  write_data = newbal.getBytes();
						     newout.write(write_data);
							  System.out.println("\nExiting.............");
							  break;
					default: System.out.println("\nInvalid choice");
				}
				}
				else
					System.exit(1);
			} while (choice != 3);
	}
}
