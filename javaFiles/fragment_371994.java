$.ajax({
    url: ROOT_URL + '/sample/profile',
    type: "get",
    dataType: "text"
}).done(function(data) {
    // handle success HTML
}).fail(function (data) {
    // parse JSON and alert error message
});