package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.*;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Classes.Car;

/**
 * Servlet implementation class ParkhausServlet
 */
@WebServlet("/ParkhausServlet")
public class ParkhausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkhausServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public static String ticketNummer;

	int[] Slot;
	private int anzahleave = 0;
	private int anzahlBesucher = 0;
	private List<Car> cars = new ArrayList<Car>();
	int[] Time = new int[25];
	private String sumDauer = "000";
	public static Float teuerstesTicket;
	public static String KundeMax;
	public static String Fahrzeugtyp;
	public static String MatrikelMax;
	private int sumFrau = 0;
	private int sumBehindert = 0;
	private int sumAndere = 0;
	private int sumFirmenKunden = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String body = getBody(request);

		String[] params = body.split(",");
		System.out.println(body);
		String event = params[0];

		// Beim Enter add new car und anzahl Besucher steigt
		if ("enter".equals(event)) {
			this.cars.add(new Car(Integer.parseInt(params[1]), null, null, params[8], params[9], params[5],
					"Parkplatz Nummer : " + params[7], params[10]));
			anzahlBesucher++;
			int randomNum = 6 + (int) (Math.random() * 24);
			Time[randomNum]++;
		}

		// Beim Leave Update the dauer and price of the car

		if ("leave".equals(event)) {
			int i, j = 0;
			for (i = 0; i < cars.size(); i++) {
				if (cars.get(i).getID() == Integer.parseInt(params[1])) {
					j = i;
					cars.get(i).setDauer((params[3]));
					cars.get(i).setPrice((params[4]));
					anzahleave++;
				}
			}

			// Einkommen Berchnen und Dadurch das teuerstesTicket und AverageGebuhre
			// berechnen
			Float sum = getPersistentSum();
			Float teuerstesTicket = getPersistentteuerstesTicket();

			// Get car Infos
			String priceString = cars.get(j).getPrice();
			String dauerString = cars.get(j).getDauer();
			String kategorie = cars.get(j).getKategorie();
			String nrTicket = cars.get(j).getTicketNummer();
			double avrGebuhr = 0.0;

			if (!"_".equals(priceString)) {
				// parse the number in string
				float price = Float.parseFloat(priceString);
				// SummeRechnen
				sum += price;
				// store sum persistently in ServletContext
				getApplication().setAttribute("sum", sum);

				// Einkomen per Kategorie
				if (kategorie.equals("Frau")) {
					sumFrau += price / 100;
				}

				if (kategorie.equals("Behindert")) {
					sumBehindert += price / 100;

				}
				if (kategorie.equals("Firmenkunden")) {
					sumFirmenKunden += price / 100;

				}
				if (kategorie.equals("Andere")) {
					sumAndere += price / 100;
				}

				// TeuresteTicket und TicketInfo Speichern
				if (price > teuerstesTicket) {
					getApplication().setAttribute("teuerstesTicket", price);
					getApplication().setAttribute("ticketNummer", nrTicket);
					String kunde = cars.get(j).getKategorie();
					String fahrzeug = cars.get(j).getType();
					String matrikel = cars.get(j).getMatrikel();

					// store Values persistently in ServletContext
					getApplication().setAttribute("KundeMax", kunde);
					getApplication().setAttribute("Fahrzeugtyp", fahrzeug);
					getApplication().setAttribute("MatrikelMax", matrikel);

				}

				// store averageParkgebhren persistently in ServletContext
				avrGebuhr = (sum / 100) / anzahleave;
				getApplication().setAttribute("averageParkgebuhren", avrGebuhr);

			}

			// Gesamte Dauer Berchenen
			if (!"_".equals(dauerString)) {
				int Sekund = 0;
				int Stunde = 0;
				int Minute = 0;

				int SekundSum = 0;
				int MinuteSum = 0;
				int StundeSum = 0;
				if (dauerString.length() < 4) {
					Sekund = Integer.parseInt(dauerString);
				} else if (dauerString.length() >= 4 && dauerString.length() < 6) {

					String sek = dauerString.substring(dauerString.length() - 3);
					Sekund = Integer.parseInt(sek);

					String min = dauerString.substring(0, dauerString.length() - 3);
					Minute = Integer.parseInt(min);

				}

				else {
					String sek = dauerString.substring(dauerString.length() - 3);
					Sekund = Integer.parseInt(sek);

					dauerString = dauerString.substring(0, dauerString.length() - 3);
					String min = dauerString.substring(dauerString.length() - 2);
					Minute = Integer.parseInt(min);

					String stun = dauerString.substring(0, dauerString.length() - 2);
					Stunde = Integer.parseInt(stun);
				}

				if (sumDauer.length() < 4) {
					Sekund = Integer.parseInt(sumDauer);
				} else if (sumDauer.length() >= 4 && sumDauer.length() < 6) {

					String sek = sumDauer.substring(sumDauer.length() - 3);
					SekundSum = Integer.parseInt(sek);

					String min = sumDauer.substring(0, sumDauer.length() - 3);
					MinuteSum = Integer.parseInt(min);

				}

				else {
					String sek = sumDauer.substring(sumDauer.length() - 3);
					SekundSum = Integer.parseInt(sek);

					sumDauer = sumDauer.substring(0, sumDauer.length() - 3);
					String min = sumDauer.substring(sumDauer.length() - 2);
					MinuteSum = Integer.parseInt(min);

					String stun = sumDauer.substring(0, sumDauer.length() - 2);
					StundeSum = Integer.parseInt(stun);
				}
				// Dauer Kunde + Gesamte Dauer
				int SekundeFinal = Sekund + SekundSum;
				int MinuteFinal = (Minute + MinuteSum) + (SekundeFinal / 1000);
				int StundeFinal = Stunde + StundeSum + (MinuteFinal / 60);
				SekundeFinal %= 1000;
				MinuteFinal %= 60;

				String s = String.valueOf(SekundeFinal);
				String m = String.valueOf(MinuteFinal);
				String st = String.valueOf(StundeFinal);

				while (s.length() < 3) {
					s = "0" + s;
				}
				while (m.length() < 2) {
					m = "0" + m;
				}
				sumDauer = st + m + s;

				Float dauer = (float) ((StundeFinal * 60 + MinuteFinal) / anzahleave);

				// store averageParkDauerpersistently in ServletContext
				getApplication().setAttribute("averageParkDauer", dauer);
			}
		}
	}

	private ServletContext getApplication() {
		return getServletConfig().getServletContext();
	}

	private double getPersistenAverageParkgebuhren() {
		double average;
		ServletContext application = getApplication();
		average = (double) application.getAttribute("averageParkgebuhren");
		if (average == 0) // double ==null
		{
			average = 0.0;
		}
		return average;
	}

	private Float getPersistentSum() {
		Float sum;
		ServletContext application = getApplication();
		sum = (Float) application.getAttribute("sum");
		if (sum == null) {
			sum = 0.0f;
		}
		return sum;
	}

	private String getPersistentTicketNummer() {

		ServletContext application = getApplication();
		ticketNummer = (String) application.getAttribute("ticketNummer");
		if (ticketNummer.length() == 0) {
			ticketNummer = "";
		}
		return ticketNummer;
	}

	private Float getPersistentAverageParkDauer() {
		Float dauer;
		ServletContext application = getApplication();
		dauer = (Float) application.getAttribute("averageParkDauer");
		if (dauer == null) {
			dauer = 0.0f;
		}
		return dauer;
	}

	private Float getPersistentteuerstesTicket() {

		ServletContext application = getApplication();
		teuerstesTicket = (Float) application.getAttribute("teuerstesTicket");
		if (teuerstesTicket == null)
			teuerstesTicket = 0.0f;
		return teuerstesTicket;
	}

	private static String getBody(HttpServletRequest request) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return stringBuilder.toString();

	}

}
