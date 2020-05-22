window.onload=function(){
     $('#.selector').change(function(){
         var row_id = $(this).attr('id');
         $.ajax({
            type: "POST",
            dataType: "json",
            url: "/ajaxpage.php",
            data: {
               id:row_id
            }
            success: function(data){
                $('#row_'+data.id).find('.price_col').html(data.cval);
            },
            failure: function(){
               alert('failed');
            }            
         });              
     });    
 }