$.ajax({
    url: 'json/pricesinputjson.json', // path to file
    dataType: 'text', // type of file (text, json, xml, etc)
    success: function(data) { // callback for successful completion
       var json = $.parseJSON(data);
       var table = $(".table");
       for(var i = 0; i < json.length; ++i) {
           // here you bind data
       }
   },
   error: function (xhr, status, error) { 
       alert("Error:" + status + ':' + error + ':' + xhr.responseText); 
   }
});