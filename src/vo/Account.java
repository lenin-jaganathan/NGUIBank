package vo;

public class Account {

	/**
	 * @param accountNumber
	 * @param balance
	 */
	
	
	
	private long accountNumber ;
	private double balance ;
	
	public Account(long accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
