<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>
<title>Insert title here</title>
</head>
<body>

<div>
<img src="https://media.giphy.com/media/l49JNZ87F3AmPoH0A/giphy.gif" alt="this slowpoke moves" style="width: 700px;height: 450px;"/>

<p style=" font-family: serif ;font-size: 30px;text-align: center;"> Diese Ticketnummer hat eine tolle Überraschung : <% Object b = application.getAttribute("ticketNummer").toString(); %>   <%=b%></p>

<p style=" font-family: Copperplate ;font-size: 50px; text-decoration: underline;  text-align: center;  text-shadow: 2px 2px red;"> 24 Stunde KOSTENLOSE PARKEN </p>

<p style=" font-family: Lucida Handwriting;font-size: 50px;   color: red;">Ticket Informationen :</p>

<p style="font-weight: bold;font-size: 30px;">Ticket Preis : <% String a = application.getAttribute("teuerstesTicket").toString();
	Float f = Float.parseFloat(a)/100; String s=String.valueOf(f) ;  s=s+" EURO"; %> <%=s%></p>

	<p style="font-weight: bold;font-size: 30px;">Fahrzeugtyp : <% String d = application.getAttribute("Fahrzeugtyp").toString();
   %> <%=d%></p>
	
	<p style="font-weight: bold;font-size: 30px;">Matrikelnummer : <% String h = application.getAttribute("MatrikelMax").toString();
	   %> <%=h%></p>


</div>
</body>
</html>