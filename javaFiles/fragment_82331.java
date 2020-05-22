$.ajax({
        url : URL,
        type : "DELETE",
        dataType : "json",
        contentType : "application/json",
        async : false,
        success : function(result){         
            Response.resolve(result);
            console.log("Response  : " + JSON.stringify(result));
           }, 
        error: function(err) { /* your code here*/})
    });