$(document).ready(function() {
    $("#LoginButtonID").click(function(){
            var link  = "http://localhost:9024/login/auth";
            var body = "{"+
                "\"Username\":\""+document.getElementById("UserNameID").value+"\", " +
                "\"Password\":\""+document.getElementById("PasswordID").value+"\"" +
                "}";
            sendRequest(link,'POST',body);

            if(data.response.toString()===("valid and successful")){
                localStorage.setItem("username",document.getElementById("UserNameID").value);
                alert("done!")
            }else if(data.response.toString()===("failed to authenticate")){
                alert("failed to login");
            }
    })
});

function sendRequest(link, type, body) {
    var xhr = new XMLHttpRequest();
    xhr.open(type, link, false);
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

    xhr.onreadystatechange = function () {
        if (xhr.readyState == XMLHttpRequest.DONE && xhr.status == 202 ) {
            data = JSON.parse(xhr.responseText);
        }else if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 401 ){
            data = JSON.parse(xhr.responseText);            }
    }
    xhr.send(body);
}