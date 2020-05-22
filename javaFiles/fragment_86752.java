public class Bridge {

    private WebEngine engine;

    public Bridge(WebEngine engine) {
        this.engine = engine;
    }

    public void addPoint(String id, String latitude, String longitude) {
        System.out.println("adding value");
        engine.executeScript(""
                + "var id=\"" + id + "\";"
                + "var latitude=\"" + latitude + "\";"
                + "var longitude=\"" + longitude + "\";"
                + "var markers=[];"
                + "markers[id] = new google.maps.Marker({\n"
                + "            draggable: false,\n"
                + "            animation: google.maps.Animation.DROP,\n"
                + "            position: new google.maps.LatLng(latitude, longitude),\n"
                + "            map: map\n"
                + "        });\n"
                + "        var bounds = new google.maps.LatLngBounds();\n"
                + "         var index;\n"
                + "         for (index = 0; index < markers.length; ++index) {\n"
                + "             bounds.extend(markers[index].getPosition());\n"
                + "         } "
                + "        map.fitBounds(bounds);");
    }

    public void doAddPoint() {
        addPoint("0", "-26.487000", "151.984000");
    }

    public void call() {
        engine.executeScript("addPoint(0,-26.487000,151.984000)");
    }

    public void log(String text) {
        System.out.println("log: " + text);
    }

    public void initMap() {
        engine.executeScript(""
                + "var map;"
                //                + "javaObj.log(\"hier0\");"
                + "map = new google.maps.Map(document.getElementById('map'), {\n"
                + "            zoom: 13,\n"
                + "            center: new google.maps.LatLng(-27.487000, 152.984000),\n"
                + "        });\n"
                //                + "javaObj.log(\"hier\");"
                + "javaObj.doAddPoint();"
        );
    }

    public void start() {
        engine.executeScript("var s = document.createElement(\"script\");\n"
                + "                          s.type = \"text/javascript\";\n"
                + "                            s.src = \"https://maps.googleapis.com/maps/api/js?key=AIzaSyBp0GrBi5GE3OPPgEm7WdStGH7A2tGuaHk&libraries=visualization&callback=javaObj.initMap\";\n"
                + "                            $(\"head\").append(s);");

    }
}