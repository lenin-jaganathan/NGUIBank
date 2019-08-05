package vo;

import java.util.Arrays;
import java.util.List;

import enums.InterestType;
import enums.LoanType;

public class Criteria {

	private InterestType interestType ;
	private LoanType loanType ;
	private float rateOfInterest ;
	private int maxRepayYear ;
	
	
	
	public InterestType getInterestType() {
		return interestType;
	}



	public void setInterestType(InterestType interestType) {
		this.interestType = interestType;
	}



	public LoanType getLoanType() {
		return loanType;
	}



	public void setLoanType(LoanType loanType) {
		this.loanType = loanType;
	}



	public float getRateOfInterest() {
		return rateOfInterest;
	}



	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}



	public int getMaxRepayYear() {
		return maxRepayYear;
	}



	public void setMaxRepayYear(int maxRepayYear) {
		this.maxRepayYear = maxRepayYear;
	}



	public Criteria(InterestType interestType, LoanType loanType, float rateOfInterest, int maxRepayYear) {
		super();
		this.interestType = interestType;
		this.loanType = loanType;
		this.rateOfInterest = rateOfInterest;
		this.maxRepayYear = maxRepayYear ;
	}



	public static List<Criteria> getCriterias() {
		
		return Arrays.asList(
					new Criteria(InterestType.COMPOUND_INTEREST, LoanType.HOUSING, 6.0f, 5),
					new Criteria(InterestType.COMPOUND_INTEREST, LoanType.EDUCATION, 8.0f, 6),
					new Criteria(InterestType.COMPOUND_INTEREST, LoanType.PERSONAL, 5.0f, 1),
					new Criteria(InterestType.SIMPLE_INTEREST, LoanType.TRAVEL, 1.0f, 1)
				);
		
	}
}
