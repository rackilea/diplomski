function login(successCallback, errorCallback, args) {
var loginData = {
    "username": args[0].username,
    "password": args[0].password
};
var dataString = JSON.stringify(loginData);
$.ajax({
    url: 'login.php',
    method: 'post',
    data: {loginData: dataString},
    dataType: 'json',
    complete: function (data) {
        console.log(data.responseText);
    },
    error: function (xhr, status, errorThrown) {
        console.log("Error: " + errorThrown);
        console.log("Status: " + status);
        errorCallback('Error logging in!');
    },
    success: function (data) {
        if (data.status == "success") {
            console.log(data.responseText);
            successCallback('Success logging in!');
        } else if (data.status = "noConnection") {
            console.log(data.responseText);
            errorCallback('Could not connect to database.');
        } else {
            console.log(data.responseText);
            errorCallback('Error logging in (but database was connected to)!');
        }
    }
});