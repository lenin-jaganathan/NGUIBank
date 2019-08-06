package validator;

import vo.UserName;

public class CustomerValidator {

	public static boolean validateUserName(UserName userName) {
		return userName.getFirstName().length() < 16 &&
				userName.getLastName().length() < 16 ;
	}
	
	public static boolean validatePhone(String phoneNumber) {
		return phoneNumber.length()==10 ;
	}
	
	
	
}
