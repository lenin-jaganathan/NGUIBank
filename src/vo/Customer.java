package vo;

import java.util.List;

public class Customer {

	private UserName userName;
	private String phoneNumber;
	private long customerId;
	private List<Address> addresses;
	private List<Account> account;
	private Customer parent;

	public UserName getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 * @param phoneNumber
	 * @param customerId
	 * @param addresses
	 * @param account
	 * @param parent
	 */
	public Customer(UserName userName, String phoneNumber, long customerId, List<Address> addresses,
			List<Account> account,Customer parent) {
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.customerId = customerId;
		this.addresses = addresses;
		this.account = account;
		this.parent = parent;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	public Customer getParent() {
		return parent;
	}

	public void setParent(Customer parent) {
		this.parent = parent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (customerId ^ (customerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId != other.customerId)
			return false;
		return true;
	}

}
