$.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        success: function (data) {
            console.log(data)
        }
    });