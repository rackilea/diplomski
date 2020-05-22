public final static ImmutableMap<String, String> mapImmutable;

static {
    Map<String,String> map2=new HashMap<String,String>();

    map2.put("name", "mark");
    mapImmutable= ImmutableMap.copyOf(map2);
    System.out.println(mapImmutable);

    Map<String,String> map3=new HashMap<String,String>();

    map3.put("Country", "USA");
    map3.put("name", "Joy");

            mapImmutable=ImmutableMap.copyOf(map3); // now we have an error!
    System.out.println(mapImmutable);}
}