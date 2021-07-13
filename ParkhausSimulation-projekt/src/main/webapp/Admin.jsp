	<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Tomcat Parkhaus</title>

<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript">
 function openPage(pageURL)
 {
 window.location.href = pageURL;
 }
</script>
<script src='https://kaul.inf.h-brs.de/ccmjs/mkaul-components/parkhaus/versions/ccm.parkhaus-10.5.6.js'></script>
 <style type="text/css">
 .button {
  transition-duration: 0.4s;
  align-content: right ;
}

.button:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}
</style>
 </head>
 
 <body>

	<a href="Connect.jsp" class="container-login100-form-btn">
		<button class="login100-form-btn" type="submit">
			Logout
		</button>
	</a>

 <ccm-parkhaus-10-5-6 server_url="http://localhost:8080/parkhaus-projekt/ParkhausServlet"
		client_categories='["Frau","Behindert","Andere","Firmenkunden"]'
		extra_buttons='["Einkommen","averageParkgebuhren","averageParkDauer","teuerstesTicket"]'
		extra_charts='["AnzahlBesucherPerKategorie","EinkommenPerKategorie","BeliebteParkplatze","AnzahlTypeFahrzeuge"]'
		price_factor='{"Frau.SUV":1,"Frau.scooter":0.8,"Frau.PKW:"1.2,"Andere.SUV":1.7,"Andere.scooter":1.5,"Andere.PKW":1.9,"Firmenkunden.SUV":0.4,"Firmenkunden.scooter":0.3,"Firmenkunden.PKW":0.5,"Behindert.SUV":0.3,"Behindert.scooter":0.2,"Behindert.PKW":0.4}'
	></ccm-parkhaus-10-5-6>



<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
</body>
	
</html>

