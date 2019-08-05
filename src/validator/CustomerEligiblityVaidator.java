package validator;

import java.util.List;

import enums.LoanType;
import vo.Account;
import vo.Criteria;
import vo.Customer;

public class CustomerEligiblityVaidator {

	private static double getTotalBalanceOfAccounts(List<Account> accounts) {
		return accounts.stream()
						.map(account -> account.getBalance())
						.reduce(0.00, Double::sum) ;
	}
	
	private static boolean checkLoanTypeEligiblity(Customer customer, LoanType loanType) {
		
		switch (loanType) {
		case HOUSING:
			double totalBalance = getTotalBalanceOfAccounts(customer.getAccount());
			return totalBalance > 1000000 ;

		case EDUCATION:
			double totalParentBalance = getTotalBalanceOfAccounts(customer.getParent().getAccount());
															
			return totalParentBalance > 500000 ;
															
		case PERSONAL :
			return true ;
		
		case TRAVEL : 
			double totalCustomerBalance = getTotalBalanceOfAccounts(customer.getAccount());
			return totalCustomerBalance > 5000000 ;
			
		default:
			return false;
		}
		
	}
	
	public static boolean checkCustomerElgiblity(Customer cutomer, LoanType loanType, double loanAmount, int numberOfYears) {
		
		if(loanAmount > 10e7) {
			return false ;
		}
		
		Criteria criteria = Criteria.getCriterias().stream()
									.filter(criteri -> criteri.getLoanType() == loanType)
									.findFirst()
									.get() ;
		
		if(numberOfYears > criteria.getMaxRepayYear())
			return false ;
		
		return checkLoanTypeEligiblity(cutomer, loanType);
		
		
	}
	
}
