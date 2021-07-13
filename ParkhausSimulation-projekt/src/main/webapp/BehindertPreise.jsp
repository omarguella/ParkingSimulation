<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}


#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
.nav {
  background-color: yellow; 
  list-style-type: none;
  text-align: center;
  margin: 0;
  padding: 0;
}

.nav li {
  display: inline-block;
  font-size: 20px;
  padding: 20px;
}
</style>
</head>
<body>

<p style=" font-family: Copperplate; font-size: 30px;   text-align: center;  color:black; text-shadow: 2px 2px 5px red;">Die Kategorie Behindert </p>
<p style=" font-family: Georgia; font-size: 30px;   color:gray;"> Preistarif  :</p>

<table id="customers">
  <tr>
    <th>Fahrzeuge</th>
    <th>Preise Pro Stunde</th>
  </tr>
  <tr>
    <td>SUV</td>
    <td>18 EURO</td>
    </tr>
  <tr>
    <td>PKW</td>
    <td>24 EURO</td>
  </tr>
    <tr>
    <td>Scooter</td>
    <td>12 EURO</td>
  
  </tr>
</table>

<ul class="nav">
  <li><a href="FrauPreise.jsp">Frau</a></li>
  <li><a href="FirmenKunden.jsp">Firmenkunden</a></li>
  <li><a href="BehindertPreise.jsp">Behindert</a></li>  
  <li><a href="AnderePreise.jsp">Andere</a></li>
</ul>

</body>
</html>
