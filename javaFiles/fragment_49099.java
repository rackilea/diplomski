function loadUser(id) {
    $.ajax({
        type: "POST",
        url: serviceBaseUrl + "user/findById",
        data: {id: id},
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success: function (data, textStatus, jqXHR) {
            if(data) {
                alert(data.files);
                /* DO SOMETHING ELSE */
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(jqXHR.responseJSON.message);
        }
    });
}