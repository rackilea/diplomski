public native void getCoordinates(com.test.GpsPanel instance)
/*-{

    function onPositionUpdate(position)
    {
        var lat = position.Wecoords.latitude;
        var lng = position.coords.longitude;
        var alt = position.coords.altitude;

        instance.@com.test.GpsPanel::testMethod()();

        alert("Coordinates retrieved: " + lat + ";" + lng + ";" + alt);
    }

    // ...
}-*/;