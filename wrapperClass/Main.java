package wrapperClass;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank = new Bank("National Australia Bank");
		
		if(bank.addBranch("Adelaide")) {
			System.out.println("Adelaide branch created");
		};
		
		bank.addCustomer("Adelaide", "Tim", 50.0);
		bank.addCustomer("Adelaide", "Mike", 175.34);
		bank.addCustomer("Adelaide", "Percy", 220.12);
		
		bank.addBranch("Sydney");
		bank.addCustomer("Sydney", "Bob", 150.54);
		
		bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
		bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
		bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
		
		bank.listCustomers("Adelaide", true);
		bank.listCustomers("Sydney", true);
		
		bank.addBranch("Melbourne");
		
		if(!bank.addCustomer("Melbourne", "Brian", 5.53)) {
			System.out.println("Error Melbourne doesn't exists");
		}
		
		if(!bank.addBranch("Adelaide")) {
			System.out.println("Adelaide already exists");
		}
		
		if(!bank.addCustomerTransaction("Adelaide", "Fergus", 52.33)) {
			System.out.println("Customer doesn't exists at branch");
		}
		
		if(!bank.addCustomer("Adelaide", "Tim", 12.21)) {
			System.out.println("Customer Tim already exists");
		}
	}

}
