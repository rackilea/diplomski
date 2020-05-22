public native void addWeatherLayer(GoogleMap map) /*-{
    var imageMapType = new $wnd.google.maps.ImageMapType({
        getTileUrl: function(coord, zoom) {
            return "http://mesonet.agron.iastate.edu/cache/tile.py/1.0.0/nexrad-n0q-900913/"+ zoom + "/" + coord.x + "/" + coord.y + ".png?" + new Date().getTime();
        },
        tileSize: new $wnd.google.maps.Size(256, 256),
        opacity:.50,
        isPng: true
    });

    map.overlayMapTypes.setAt("0", imageMapType);

}-*/;