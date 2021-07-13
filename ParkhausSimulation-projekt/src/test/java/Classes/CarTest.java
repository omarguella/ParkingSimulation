package Classes;

import static org.junit.jupiter.api.Assertions.*;
 import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
	Car car1;
	Car car2;

	@BeforeEach
	void setUp() throws Exception {
		car1 = new Car(Integer.parseInt("32"), "1980", "198", "Firmenkunden", "Scooter",
				"2318d39c062c053c26ae91252ee8ea0d", "Parkplatz Nummer : " + "6", "SU-Q 39");

		car2 = new Car(Integer.parseInt("18"), "6520", "652", "Frau", "SUV", "231fdfcdf3c26ae91258dfgf8d",
				"Parkplatz Nummer : " + "10", "SU-Q 48");
	}

	@Test
	void getKategorieTest() {
		assertEquals("Firmenkunden", car1.getKategorie(), "passt");
	}
	@Test
	void getTypeTest() {
		assertEquals("Scooter", car1.getType(), "Passt");
	}
	@Test
	void getFalschTypeTest() {
		assertNotEquals("PKW", car1.getType(), "Falsche Type");
	}
	@Test
	void getFalschIDTest() {
		assertNotEquals(car1.getType(), car2.getType(), "ID of cars is not equals");
	}
	@Test
	void toStringTest() {
		assertEquals(
				"Car [ID=" + "32" + ", Dauer=" + "1980" + ", price=" + "198" + ", kategorie=" + "Firmenkunden"
						+ ", type=" + "Scooter" + ", TicketNummer=" + "2318d39c062c053c26ae91252ee8ea0d" + ", slot="
						+"Parkplatz Nummer : "+ "6" + ", Matrikel=" + "SU-Q 39" + "]",car1.toString(), "To String methode ist richtig geschrieben");
	}
}
