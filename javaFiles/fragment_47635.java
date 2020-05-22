class Data {
    private String type;
    private List<Feature> features;
}

class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;
}

class Properties {
    private String NAME;
    private String bannedOrCensored;
    private Integer Bombed;
    private Double LON;
    private Double LAT;
}

class Geometry {
    private String type;
    private Double[][][][] coordinates;
}