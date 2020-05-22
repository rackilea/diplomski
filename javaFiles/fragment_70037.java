$( "#myform" ).submit(function( event ) {
    var verificationURL = "/verifycreds.php?username=" 
                          + $('#username').val() 
                          + "&password=" + $('#password').val();
    $.get(verificationURL, function(data) {
        if(!data.success) {
            event.preventDefault();
            // Display popup of your choice here with data.message
        }
    });
});