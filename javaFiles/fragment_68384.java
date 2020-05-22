setInterval(function(){
   //Here goes your ajax call
   $.ajax({
     ...
     type: 'post',
     success: function(data){
        ...            
        if(objectChanged){
           //Do your stuff here
        }  
     }
   });
}, 5000); //Check each 5 seconds