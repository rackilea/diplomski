@Type(type = "hstore")
@Column(name = "tags", columnDefinition = "hstore")
private Object2ObjectOpenHashMap<String, String> tags = new Object2ObjectOpenHashMap<String, String>(); 

@Column(name = "bbox")
private Geometry bbox;

@Column(name = "linestring")
private Geometry linestring;