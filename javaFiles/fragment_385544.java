function loadAjax() {
        $.ajax({
            type : "GET",
            url : "http://localhost:8080/song-player/ajax.json",
            async : false,
            dataType: "jsonp",
            success : function(response) {
                            $('#ajax').text(response.streamUrl);
                alert('Success: ' + response);
            },
            error : function(e) {
                alert('Error: ' + e);
            }
        }).done(function(data) {
            console.log(data);
            console.log(data.streamUrl);
        });
    }