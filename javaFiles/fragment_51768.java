$.ajax({
    url: "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
    type: "POST",
    contentType: 'application/json',
    data: formData,
    dataType: "json",
    complete: function(data) {
        $("#loading").hide();
        if (data.status == 0) {
            sessionStorage("userId", data.userId);
            $("body").load(path + "pages/back/menuPage.html");
            $.getScript(path + "js/back/menuPage.js", function() {
                if (currentPage.init) {
                    currentPage.init();
                }
            });
        } else {
            navigator.notification.alert('No. kad pengenalan dan kata laluan tidak sah. ', null, 'Amaran', 'Ok');
        }
    }
});