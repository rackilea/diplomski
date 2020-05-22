$(document).ready(function () { 
    $("#tabs").tabs();
});

$(window).load(function() {
    jsf.ajax.addOnEvent(function (data) {
        if (data.status === "success") {
                $("#tabs").tabs();
        }
    });
});