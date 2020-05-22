$.ajax({
        type: "POST",
        url: "/demo/submitTransactions",
        data: JSON.stringify({ ConfirmedTransactions: confirmedTransactions }),
        contentType: "application/json; charset=utf-8",
        dataType: "text"
    })
     .done(function(data){alert(data);})
     .fail(function(errMsg) {alert(errMsg);})
     ;