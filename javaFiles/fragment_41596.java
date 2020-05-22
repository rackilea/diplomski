function update(){
    var callback = {
        success: function (o) {
            var response = YAHOO.lang.JSON.parse(o.responseText);
            map.panTo({lat: response.lat, lng: response.longi}); // map is the google.maps.Map representing your map
        },
        failure: function (o) {

        }
    }
    var sUrl = '/getData.htm'; // This is the request mapping for your bean
    YAHOO.util.Connect.asyncRequest('GET', sUrl,callback);
}

function init(){
    setTimeout("update()", 2000);
}