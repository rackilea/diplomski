$.get("<your application context url>/configuration/check",
    function(data, status){
        // This function is called when the response is available.
        // Response data is available in data field.
        // Status field tells if the request was success or error occurred.
        alert("Data: " + data + "\nStatus: " + status);
    }).done(function() {
        // This function is called when the response is successfully processed.
        // Here you can chain further requests which should only be dispatched
        // once the current request is successfully finished
    }).fail(function() {
        // This function is called when the response is an error.
        // Here you can chain further requests which should only be dispatched
        // if the current request encounters an error
    });

// Statements after $.get function, will continue executing immediately
// after issuing the request. They won't wait for response
// unlike the above "done" and "fail" functions