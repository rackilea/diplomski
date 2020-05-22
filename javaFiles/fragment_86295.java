jQuery.ajax({  
    type: "POST",  
    url: urlString,
    contentType: "application/json",
    data: dataString,
    dataType:  'json',
    processData: false,
    success: function( returnData ) {  
        jQuery('#content').html(JSON.stringify(returnData));
    },
    fail: function( returnData ) {  
        alert("FAIL");
    }
});