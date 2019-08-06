/**
 * 
 */
package frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import enums.LoanType;
import validator.CustomerEligiblityVaidator;
import validator.CustomerValidator;
import vo.Account;
import vo.Address;
import vo.Customer;
import vo.UserName;

/**
 * @author gravichandran
 *
 */
public class CustomerImplementation {
	static List<Address> setAddress(String city, int houseNumber, long zip, String area, String state) {
		List<Address> addressList = new ArrayList<Address>();
		Address add1 = new Address(city, houseNumber, zip, area, state);
		addressList.add(add1);
		return addressList;
	}

	static void printCustomers(ArrayList<Customer> custObject) {
		Random rand = new Random();
		for (Customer custObj : custObject) {
			System.out.println("\t\t---------------Customer Details----------------");
			System.out.println("Name : " + custObj.getUserName());
			if (CustomerValidator.validateUserName(custObj.getUserName())) {
				System.out.println("This is a valid username");
				System.out.println("Customer Id : " + custObj.getCustomerId());
				if (CustomerValidator.validatePhone(custObj.getPhoneNumber())) {
					// System.out.println("Valid phone number");
					// List<Account> accObject = new ArrayList<Account>();
					for (Address add : custObj.getAddresses()) {
						System.out.println("Address : " + add.houseNumber + "," + add.area + "," + add.city + ","
								+ add.state + "," + add.zip);
					}
					if (custObj.getParent() == null) {
						System.out.println("Parent doesn't have a account in this bank");
					} else {
						System.out.println("\nParent's cust Id: " + custObj.getParent().getCustomerId());
					}
					for (Account acc : custObj.getAccount()) {
						System.out.println("\n\t\t Account Details");
						System.out.println("Account number : " + acc.getAccountNumber());
						System.out.println("Balance : " + acc.getBalance());
					}
					int repayYears = rand.nextInt(5)+1;
					System.out.println("\nRepay years : "+repayYears);
					System.out.println("\n \t<==Eligible Loans==>");
					
					if (CustomerEligiblityVaidator.checkCustomerElgiblity(custObj, LoanType.EDUCATION, 10000,
							repayYears))
						System.out.println("Education");
					if (CustomerEligiblityVaidator.checkCustomerElgiblity(custObj, LoanType.HOUSING, 10000,
							repayYears))
						System.out.println("Housing");
					if (CustomerEligiblityVaidator.checkCustomerElgiblity(custObj, LoanType.PERSONAL, 10000,
							repayYears))
						System.out.println("Personal");
					if (CustomerEligiblityVaidator.checkCustomerElgiblity(custObj, LoanType.TRAVEL, 10000,
							repayYears))
						System.out.println("Travel");
				} else {
					System.out.println("Invalid Phone number");
				}
			} else {
				System.out.println("Invalid username");
			}
		}
	}

	/**
	 * @param args
	 * @param HOUSING
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer> custObject = new ArrayList<Customer>();
		
		List<Account> accObject = new ArrayList<Account>();
		accObject.add(new Account(983457, 10000000));
		
		
		
		List<Address> addresses = setAddress("Adyar", 12, 635305, "Chennai", "TN");
		custObject.add(new Customer(new UserName("Kumar", "S"), "9800999910", 12345l, addresses, accObject, null));
		
		List<Account> accObject1 = new ArrayList<Account>();
		accObject1.add(new Account(983458, 5000000));
		addresses = setAddress("Adyar", 12, 635305, "Chennai", "TN");
		custObject.add(new Customer(new UserName("Singh", "P"), "8100119910", 123452, addresses, accObject1, custObject.get(0)));
		
		List<Account> accObject2 = new ArrayList<Account>();
		accObject2.add(new Account(983459, 10000));
		addresses = setAddress("OMR", 32, 635305, "Chennai", "TN");
		custObject.add(new Customer(new UserName("Kappor", "PS"), "9900512910", 123453, addresses, accObject2,null));
		printCustomers(custObject);
		
	}

}
