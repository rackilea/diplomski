//param: json structure of parameters
function reloadAjaxPanel(param) {
    $.get("/ajaxController", param, function(data) {
        $("#container").html(data);
    }); 
}