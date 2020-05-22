$(document).ready(function () {

    $("#your-form").submit(function (event) {

        //stop form submission, send manually
        event.preventDefault();

        do_ajax_submit();

    });

});

function do_ajax_submit() {

    var val = //Get the value here

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/endpoint",
        data: JSON.stringify(val),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
           // Do something
        },
        error: function (e) {
           // Do something
        }
    });

}