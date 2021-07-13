package servlets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Classes.CheckingLogin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoginServletTest {
	
	
	  @Test
	    @DisplayName("check if Betreiber richtig einloggen")
	    void BetreiberTest() {
	        assertEquals("admin", CheckingLogin.CheckingUser("admin", "admin"),"Betreiber richtig eingeloggt");
	    }
	  @Test
	    @DisplayName("check if Kunde richtig einloggen")
	    void KundeTest() {
			assertEquals("kunde", CheckingLogin.CheckingUser("kunde", "kunde")," Kunde richtig eingeloggt");
	    }
  
	  @Test
	    @DisplayName("check if Betreiber FLASCH einloggen")
	    void BetreiberFlaschTest() {
		  assertNotEquals("Betreiber", CheckingLogin.CheckingUser("Betreiber", "omar"),"Betreiber falsch eingeloggt");
	    }
   
	  @Test
	    @DisplayName("check if Kunde FLASCH einloggen")
	    void KundeFlaschTest() {
		  assertNotEquals("Kunde", CheckingLogin.CheckingUser("Kunde", "zied"),"Kunde falsch eingeloggt");
	    }
 
}
