package vo;

public class UserName {

	public String firstName ;
	public String lastName ;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "UserName [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
