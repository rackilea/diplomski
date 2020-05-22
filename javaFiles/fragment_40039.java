class GeoResponse {
   private String type;
   private Metadata metadata;
   private List<Feature> features;

   // so on
   // getters and setters
}

class Metadata {
   private String generated;
   private String url;
   // so on
   // getters and setters
}
class Feature {
   private String id;
   private String type;
   private Properties properties;
   // so on
}
// so on