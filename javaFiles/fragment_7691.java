function poll(){
    $.ajax({ 
        url: "/systemcommand", 
        success: function(data){
            // redirect to next page here
            document.location.href = '/output'
        }, 
        complete: poll, 
        timeout: 20000  
    });
};