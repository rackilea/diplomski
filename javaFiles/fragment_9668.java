saveTransactionResult : function(result) { // save result to server.
    $.ajax({
        headers : {
            Accept : "text/plain",
            "Content-Type" : "application/json"
        },
        url : "/myshop/checkout/payment/complete",
        type : "POST",
        data : JSON.stringify(result),
        dataType : "text",
        contentType : "application/json; charset=utf-8",
        success : function(data) {
            console.log(data);
            console.log("Payment Details have been saved!");
        },
        error : function() {
            console.log("an error has occurred while posting response!");
        }
    });
}