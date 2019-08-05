package service;

import enums.InterestType;
import enums.LoanType;
import vo.Criteria;

public class LoanCalculator {

	private static double calculateCompundInterest(double principal, float rate, int duration) {
		
		return principal* Math.pow((1 + (rate / 100)), duration ) ;
		
	}
	
	private static double calculateSimpleInterest(double principal, float rate, int duration) {
		
		return principal * rate * duration / 100 ;
		
	}
	
	public static double calculateInterest(double loanAmount, LoanType loanType, int yearsToRepay) {
		
		Criteria loanCreteria = Criteria.getCriterias().stream()
														.filter(criteria -> criteria.getLoanType()==loanType)
														.findFirst()
														.get() ;
		
		if(loanCreteria.getInterestType() == InterestType.SIMPLE_INTEREST) {
			
			return calculateSimpleInterest(loanAmount, loanCreteria.getRateOfInterest(), yearsToRepay) ;
			
		} else {
			
			return calculateCompundInterest(loanAmount, loanCreteria.getRateOfInterest(), yearsToRepay) ;
			
		}
		
	}
	
}
