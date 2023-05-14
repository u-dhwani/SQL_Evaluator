<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>IT-214 DATABASE MANAGEMENT SYSTEM</title>
	<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" /> 
    
    <script>

	$(document).ready(function(){
		$("form").submit(function(event){
			event.preventDefault(); // prevent the form from submitting
			$.post("Start_Quiz", $(this).serialize(), function(data){
				// do something with the response from the servlet (if any)
			});
		});
	});
	
	$(document).ready(function() {
		  $(".redirect").click(function() {
		    $(this).css("background-color", "green"); /* Change to desired color */
		    $(this).css("color", "white"); /* Change to desired color */
		  });
		});
	
	$(document).ready(function() {
		  $(".submitbutton").click(function() {
		    $(this).css("background-color", "red"); /* Change to desired color */
		    $(this).css("color", "white"); /* Change to desired color */
		  });
		});
    </script>

</head>
<body>
	<div class="full-page">
        <div class="navbar">
          <div>
              	<a href="index.jsp"><img src="images/daiict_logo.png" style="height: 150px;"></a>
          </div>
            <div style="margin-left: 350px;">
                <a href='website.html' style="color: black; font-weight: bold;">IT-214 DATABASE MANAGEMENT SYSTEM</a>
               
            </div>
            <nav>
                <ul id='MenuItems'>
			<li style="font-weight: bold;"><a href="login.jsp">LOGOUT</a></li>
                </ul>
            </nav>
            
        </div>
       	<div>
            <a href="quiz_question.jsp">
            	<button type='submit' id="start_sql" class='submit-btn' 
            		style="width: 500px; height: 100px; background-color: lightblue; font-weight: bolder; margin-top: 10%; 
            		font-size: xx-large;">START QUIZ
            	</button>
            </a>
    	</div>
    	
    	
    	
    	
    	
    <script>
        var x=document.getElementById('login');
		var y=document.getElementById('register');
		var z=document.getElementById('btn');
		function register()
		{
			x.style.left='-400px';
			y.style.left='50px';
			z.style.left='110px';
		}
		function login()
		{
			x.style.left='50px';
			y.style.left='450px';
			z.style.left='0px';
		}
	</script>
	<script>
        var modal = document.getElementById('login-form');
        window.onclick = function(event) 
        {
            if (event.target == modal) 
            {
                modal.style.display = "none";
            }
        }
    </script>
    <script>
    function openLocalSoftware() {
        window.location.href = "file:///C:\Users\HP\Downloads\SetupRelational.exe";
    }
    </script>
    <script>
    function openIDE() {
  	  var xmlhttp = new XMLHttpRequest();
  	  xmlhttp.onreadystatechange = function() {
  	    if (this.readyState == 4 && this.status == 200) {
  	      console.log("IDE opened");
  	    }
  	  };
  	  xmlhttp.open("GET", "OpenIDE", true);
  	  xmlhttp.send();
  	}
    </script>
</body>
</html>