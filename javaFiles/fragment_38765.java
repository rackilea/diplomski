setInterval(function() {
   $.ajax({  
     url:'TimerAjax?userid='+document.getElementById("uid").value,
     type:'post', 
     dataType: 'json',  
     success: function(data) { 
            $('#lblscore').html(data.score); //Here use html()
           }  
      });  
 }, 5000);