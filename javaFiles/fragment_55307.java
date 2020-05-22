public native void getCoordinates()
/*-{

    var that = this;

    function onPositionUpdate(position) {
        var lat = position.Wecoords.latitude;
        var lng = position.coords.longitude;
        var alt = position.coords.altitude;

        that.@com.test.GpsPanel::testMethod()();

        alert("Coordinates retrieved: " + lat + ";" + lng + ";" + alt);
    }

    // ...
}-*/;