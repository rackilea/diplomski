$('#uploadButton').click(function() {
    var file = document.getElementById('files');
    for (var i = 0, f; f = file.files[i]; ++i) {
        console.log(f.webkitRelativePath);
    }
    var fd = new FormData($('#uploadForm')[0]);
    var url = [my local machine]/GProject/uploadFolder;
    var cookieVal = RemoteJSvar.userId; 
    var auth = ['Super_Complex_Auth', cookieVal];

    var request = new XMLHttpRequest();
    request.open("POST", url);
    request.setRequestHeader('Authorization',auth);
    request.onreadystatechange = function() {//Call a function when the state changes.
        if(request.readyState == 4) {
            console.log("responseText=" +request.responseText +", status="+request.status +", statusText="+request.statusText);
        }
    }       
    request.send(fd);
});