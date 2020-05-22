$(document).ready(function(){
   $("#email").keyup(function(){
     var email = $(this).val();
    // here you can validate email and show alert or show message into your error box.
        var pattern=/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if(pattern.test(email)){
            $("#errmsgbox").html("Valid email address");
        }else{
            $("#errmsgbox").html("Please enter valid email address");
        }
   });
});