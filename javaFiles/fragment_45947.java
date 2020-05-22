function sendAjaxRequest() {
    var country = $("#country").val();
    $.get( "/regions?country=" + country, function( data ) {
        $("#region").empty();
        data.forEach(function(item, i) {
            var option = "<option value = " + item + ">" + item +  "</option>";
            $("#region").append(option);
        });
    });
};