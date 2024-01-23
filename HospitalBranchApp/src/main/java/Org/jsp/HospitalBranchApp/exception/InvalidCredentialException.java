package Org.jsp.HospitalBranchApp.exception;

public class InvalidCredentialException  extends RuntimeException{

	@Override
	public String getMessage() {
		return " invalid credentials";
	}
}
