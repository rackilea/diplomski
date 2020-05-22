function startDownload(form) {
    var token = new Date().getTime();
    form.token.value = token;
    form.Submit.disabled = true;

    var pollDownload = setInterval(function() {
        if (document.cookie.indexOf("download=" + token) > -1) {
            document.cookie = "download=" + token + "; expires=" + new Date(0).toGMTString() + "; path=/";
            form.Submit.disabled = false;
            clearInterval(pollDownload);
        }
    }, 500);
}