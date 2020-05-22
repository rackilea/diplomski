$.ajax({
   type: "POST",
   url: "/app/servlet/",
   data: {name : "John", location : "Boston"},
   success: function(msg){
     alert( "Data Saved: " + msg );
   }
 });