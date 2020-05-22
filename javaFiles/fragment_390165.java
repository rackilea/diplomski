window.onload=function(){
     $('#select_id').change(function(){
         var currency = $(this).val();
         $.ajax({
            type: "POST",
            dataType: "json",
            url: "/ajaxpage.php",
            data: {
               currency:currency
            }
            success: function(data){
               $.each($('#table tr ',function(index,value){
                   $(this).find('.price_col').html(data[index]);   
               });
            },
            failure: function(){
               alert('failed');
            }            
         });              
     });    
 }