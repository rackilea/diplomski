$(function () {
    var token = $("input[name='_csrf']").val();
    var header = "X-CSRF-TOKEN";
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
});

$.ajax({
    url: "./delete/car",
    type: "POST",
    success:function(response) {
        alert(response);
    }
});