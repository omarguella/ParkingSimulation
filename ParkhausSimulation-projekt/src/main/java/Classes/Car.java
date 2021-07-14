package Classes;

import Interfaces.CarIF;

public class Car implements CarIF {

	private int ID;
	private String Dauer;
	private String price;
	private String kategorie;
	private String type;
	private String TicketNummer;
	private String slot;
	private String Matrikel;

	public Car(int ID, String Dauer, String price, String kategorie, String type, String TicketNummer, String slot,String Matrikel) {
		this.ID = ID;
		this.Dauer = Dauer;
		this.price=price;
		this.TicketNummer = TicketNummer;
		this.kategorie = kategorie;
		this.type = type;
		this.slot = slot;
		this.Matrikel = Matrikel;

	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void setID(int iD) {
		this.ID = iD;
	}

	@Override
	public String getDauer() {
		return Dauer;
	}

	@Override
	public void setDauer(String dauer) {
		this.Dauer = dauer;
	}
	@Override
	public String getPrice() {
		return price;
	}
	@Override
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String getKategorie() {
		return kategorie;
	}

	@Override
	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	@Override
	public String getTicketNummer() {
		return TicketNummer;
	}
	@Override
	public void setTicketNummer(String ticketNummer) {
		this.TicketNummer = ticketNummer;
	}

	@Override
	public String getSlot() {
		return slot;
	}
	@Override
	public void setSlot(String slot) {
		this.slot = slot;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Car [ID=" + ID + ", Dauer=" + Dauer + ", price=" + price + ", kategorie=" + kategorie + ", type=" + type
				+ ", TicketNummer=" + TicketNummer + ", slot=" + slot + ", Matrikel=" + Matrikel + "]";
	}
	@Override
	public String getMatrikel() {
		return Matrikel;
	}
	
	@Override
	public void setMatrikel(String matrikel) {
		Matrikel = matrikel;
	}

}
