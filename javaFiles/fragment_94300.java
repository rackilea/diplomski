function selectDomainSuccessHandler(json) {
    // it is possible to send back a 200 response after failing to process the request,
    // in which case, the sojoView will have set success=false in the json
    if (json.success == true) {
        // parse json here and render it into html in your document
    } else {
        // get field error and global error from json and present to user
    }
}

function(selectDomainErrorHandler(xhr, returnCode) {
    // do something based on the return code
}

var options = {
    success: selectDomainSuccessHandler,
    error: selectDomainErrorHandler,
    dataType: 'json'
};

$('selectDomainForm').ajaxForm(options);