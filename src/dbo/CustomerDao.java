package dbo;

import java.util.List;

import vo.Customer;

public class CustomerDao {

	private static List<Customer> customers;

	public static void addCustomer(Customer c) {
		customers.add(c);
	}

	public static Customer getById(long id) {
		return customers.stream().filter(customer -> customer.getCustomerId() == id).findFirst().get();
	}

}
