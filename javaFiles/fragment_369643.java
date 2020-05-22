import org.geojson.*

// ...

public class ReadJSONFile {

    ObjectMapper om = new ObjectMapper();

    public void mapToObject(String url) throws Exception {

        Map<String, Object> resultMap = om.readValue(new URL(url), new TypeReference<Map<String, Object>>() {});
        List<Feature> features = om.convertValue(resultMap.get("features"), new TypeReference<List<Feature>>() {});

        for(Feature f : features) {
            // Write the feature to the console to see how it looks like
            System.out.println(om.writeValueAsString(f));
            // Extract properties
            Map<String,Object> properties = f.getProperties();
            // ....
            // Extract geometry
            GeoJsonObject geometry = f.getGeometry();
            if(geometry instanceof Point) {
                Point p = (Point) geometry;
                // do something with the point
            }  else if(geometry instanceof LineString) {
                LineString mls = (LineString) geometry;
                // ...
            } else if(geometry instanceof MultiLineString) {
                MultiLineString mls = (MultiLineString) geometry;
                // ...
            } else if(geometry instanceof MultiPoint) {
                MultiPoint mp = (MultiPoint) geometry;
                // ...
            } else if(geometry instanceof Polygon) {
                Polygon pl = (Polygon) geometry;
                // ...
            } else if(geometry != null) {
                throw new RuntimeException("Unhandled geometry type: " + geometry.getClass().getName());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReadJSONFile rjf = new ReadJSONFile();
        rjf.mapToObject("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
    }
}