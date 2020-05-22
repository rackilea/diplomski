$("#submit").click(function(){

        var response = '';
        $.ajax({ type: "GET",   
                 url: "ajaxprintcoupon",   
                 async: false,
                 success : function(text)
                 {
                     response = text;
                 }
        });

        alert(response);

        if(response == 'Testing'){
            $('#printCoupon').submit();
        }else{
            // no change
        }
    });