function doLogin(){
    clearErrorMsg("login-alert");
    var data = new Object();
    data.username = $('#username').val();
    data.username = $('#password').val();
    $.ajax({
        data: JSON.stringify(data),
        timeout: ajaxTimeout,
        type: 'POST',
        url: rootURL +'/login',
        contentType: "application/json"
    }).done(function(data, textStatus, jqXHR) {
        window.location.href = rootURL + "/home.html";
    }).fail(function(jqXHR, textStatus, errorThrown) {
        displayErrorMsg("login-alert", "Wrong credentials, try again! <br >Error code: [" + errorThrown + "]");
    });
}