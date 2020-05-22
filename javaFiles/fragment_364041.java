$.ajax({
    url: theUrl,
    type: "POST",
    data: JSON.stringify(dataString),
    dataType: "json",
    contentType: "application/json",
    success: function(response) {
        alert(JSON.stringify(response));
    }
});