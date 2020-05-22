$.ajax({
    url: 'http://www.remote_domain.com/json.php',
    dataType: 'jsonp',
    success: function(data){

        $.each(data, function(k, v){
            console.log('key: ' + k + ' val: ' + v);
        });
    }
});