Object obj = parser.parse(new FileReader( "file.json" ));
  JSONObject jsonObject = (JSONObject) obj;
   JSONArray loc= (JSONArray) jsonObject.get("locations");
    Iterator i = loc.iterator();


     while (i.hasNext()) {
    JSONObject geo   = (JSONObject) (i.next());

    JSONObject coords   = (JSONObject)geo.get("geometry");
    String coord= (String)coords.get("Coords");
        System.out.println(coord);
    }