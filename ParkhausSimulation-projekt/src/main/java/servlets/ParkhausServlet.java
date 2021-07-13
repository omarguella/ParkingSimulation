package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
