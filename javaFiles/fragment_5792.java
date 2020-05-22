$.ajax({ type: "GET",   
     url: "/YourServletURL",   
     success : function(text)
     {
         var list = text.split(',');
         $.each(list, function(index, value) { 
          alert(index + ': ' + value); 
         });
         // This will show the values. Change "alert" for $('div#mydiv').html(value) or so
     }
});