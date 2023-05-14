<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IT-214 DATABASE MANAGEMENT SYSTEM</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <link rel="shortcut icon" href="#">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script src="js/timer.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	 <script>

	/* document.getElementById("submit_student").addEventListener("click", function() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // handle the response from the servlet
        }
    };
    xhttp.open("GET", "Quiz_Question", true);
    xhttp.send();
}); */

	$(document).ready(function(){
		$("form").submit(function(event){
			event.preventDefault(); // prevent the form from submitting
			$.post("quiz_question", $(this).serialize(), function(data){
				// do something with the response from the servlet (if any)
			});
		});
	});
	
		$(document).ready(function() {
			  $(".savebutton").click(function() {
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
    
    <div class="box">
    
   <%--  <% String name=request.getParameter("studentid");%>
    <h2 style="text-align:center; font-weight:bold;">Welcome, <%=name%></h2> --%>
    
    <img src="images/lib-db.jpg" alt="library database">
    
        <div class="title">
            Question 1
        </div>
        <div class="header">
            <div class="timerbox">Time Left: <span></span></div>
        </div>
        <div class="questionbox">
            Retrieve details of all books in the library : id, title, name of publisher, authors, number of copies in each branch, etc.
        </div>
        <br>
        <form method="post" action="quiz_question" >
	        <div class="answerbox" id="q1_answer">
	            <!-- <textarea></textarea> -->
	            <input class="inputarea" name="answer_q1">
	        </div>
	        <br>
	        
	        <button style="margin-left: 700px;">
	        	<div class="form-group form-button" style="text-align:right; width:100%; padding:0;"> 
					<input type="submit" name="button" id="q1_save" class="savebutton" value="Save">
				</div>
			</button>
		</form>

        <br><br><hr class="break"><br>

        <div class="title">
            Question 2
        </div>
        <div class="header">
            <div class="timerbox">Time Left: <span></span></div>
        </div>
        <div class="questionbox">
            Get the particulars of borrowers who have borrowed more than 3 books, but from Jan 2017 to Jun 2022.
        </div>
        <br>
        <form method="post" action="quiz_question" >
	        <div class="answerbox" id="q2_answer">
	            <!-- <textarea></textarea> -->
	            <input class="inputarea" name="answer_q2">
	        </div>
	        <br>
	        <button style="margin-left: 700px;">
	        	<div class="form-group form-button" style="text-align:right; width:100%; padding:0;"> 
					<input type="submit" name="button" id="q1_save" class="savebutton" value="Save">
				</div>
			</button>
		</form>

        <br><br><hr class="break"><br>

        <div class="title">
            Question 3
        </div>
        <div class="header">
            <div class="timerbox">Time Left: <span></span></div>
        </div>
        <div class="questionbox">
            Retrieve publisher phone number and address of title DBMS.
        </div>
        <br>
        <form method="post" action="quiz_question" >
	        <div class="answerbox" id="q3_answer">
	            <!-- <textarea></textarea> -->
	            <input class="inputarea" name="answer_q3">
	        </div>
	        <br>
	        <button style="margin-left: 700px;">
	        	<div class="form-group form-button" style="text-align:right; width:100%; padding:0;"> 
					<input type="submit" name="button" id="q1_save" class="savebutton" value="Save">
				</div>
			</button>
		</form>

        <br><br><hr class="break"><br>

        <div class="title">
            Question 4
        </div>
        <div class="header">
            <div class="timerbox">Time Left: <span></span></div>
        </div>
        <div class="questionbox">
            Retrieve BookId, Title, NoofCopies, Address of Branch Name RR NAGAR. 
        </div>
        <br>
        <form method="post" action="quiz_question" >
	        <div class="answerbox" id="q4_answer">
	            <!-- <textarea></textarea> -->
	            <input class="inputarea" name="answer_q4">
	        </div>
	        <br>
	        <button style="margin-left: 700px;">
	        	<div class="form-group form-button" style="text-align:right; width:100%; padding:0;"> 
					<input type="submit" name="button" id="q1_save" class="savebutton" value="Save">
				</div>
			</button>
		</form>

        <br><br><hr class="break"><br>

        <div class="title">
            Question 5
        </div>
        <div class="header">
            <div class="timerbox">Time Left: <span></span></div>
        </div>
        <div class="questionbox">
            Retrieve Book Id, Title, PublisherName, AuthorName.
        </div>
        <br>
        <form method="post" action="quiz_question" >
	        <div class="answerbox" id="q5_answer">
	            <!-- <textarea></textarea> -->
	            <input class="inputarea" name="answer_q5">
	        </div>
	        <br>
	        <button style="margin-left: 700px;">
	        	<div class="form-group form-button" style="text-align:right; width:100%; padding:0;"> 
					<input type="submit" name="button" id="q1_save" class="savebutton" value="Save">
				</div>
			</button>
			<br><br><br>
			<div class="form-group form-button">
				<a style="text-decoration: None;">
					<input type="submit" name="button" id="submit_student" class="submitbutton" value="Submit" onclick="redirectToLogin()"/>
				</a>
			</div>
		</form>
    </div>
    
    <script>
    function redirectToLogin() {
        window.location.href = "login.jsp";
    }
	</script>

</body>



</html>