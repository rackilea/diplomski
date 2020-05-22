public class Quickstart {

public static void main(String[] args) throws Exception {
    File file = JFileDataStoreChooser.showOpenFile("shp", null);
    if (file == null) {
        return;
    }

    FileDataStore store = FileDataStoreFinder.getDataStore(file);
    SimpleFeatureSource featureSource = store.getFeatureSource();

    // Create a map content and add our shapefile to it
    MapContent map = new MapContent();
    map.setTitle("Quickstart");

    Style style = SLD.createSimpleStyle(featureSource.getSchema());
    Layer layer = new FeatureLayer(featureSource, style);
    map.addLayer(layer);

    // Display the map
    JMapFrame.showMap(map);
}
}