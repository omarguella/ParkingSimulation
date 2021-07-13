package Classes;

public class CheckingLogin {
	 public static String CheckingUser(String name, String passwort) {
	        return (name.equals("kunde") && passwort.equals("kunde")) ? "kunde" :(name.equals("admin") && passwort.equals("admin")) ? "admin" : "wrongID";
	    }
}
