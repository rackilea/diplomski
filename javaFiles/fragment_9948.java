$.ajax({
        type: "GET",
        url: urln,
        accept : "text/html",         // <= changed these lines
        dataType : "html",            // <= changed these lines
        success: function (data) {

            alert(data);
        },
        error: function (XMLHttpRequest, textStatus,
                         errorThrown) {
            alert(textStatus);
        }
    });