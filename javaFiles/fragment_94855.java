$.ajax({     
    type: 'GET',     
    url: 'http://api.instagram.com/oembed?callback=&url=http://instagram.com/p/Y7GF-5vftL‌​/',     
    cache: false,     
    dataType: 'jsonp',     
    success: function(data) {           
        try{              
            var media_id = data[0].media_id;          
        }catch(err){}   
    } 
});