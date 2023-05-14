$(function(){
	let timeLeft=3600;
	let min=0;
	let sec=0;
	let counter=0;
	let timer=setInterval(function(){
		counter++;
		min=Math.floor((timeLeft-counter)/60);
		sec=timeLeft-(min*60)-counter;
		//console.log("min:"+min);
		//console.log("sec:"+sec);
		$(".timerbox span").text(min+":"+sec);
		if(counter==timeLeft){
			alert("Time's up. Press OK to submit your answers.")
			clearInterval(timer);
		}
	},1000);
	
	//printQuestion(index);
});


/*function printQuestion(i){
	console.log(questions[0]);
	//console.log(quiz);
	//$(".questionbox").text(questions[i].question);
}*/