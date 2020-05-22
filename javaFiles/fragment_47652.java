$.ajax({
    url:    "get_label",
    mimeType:"text/html; charset=UTF-8",
    success:    function(result)
    {
        alert(result);
        $("#parameter_select label").text(result);
    }
});