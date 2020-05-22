CouchDbClient dbClient = new CouchDbClient();

DesignDocument designDocument = new DesignDocument();
designDocument.setId("_design/mydesign");
designDocument.setLanguage("javascript");

MapReduce get_numberOfSeasonsMR = new MapReduce();
get_numberOfSeasonsMR.setMap(
  "function(doc) { "
   + "  emit(doc.seriesName, doc.season)"
   + "}");
get_numberOfSeasonsMR.setReduce(
  "function (key, values, rereduce) {"
    + "return Math.max.apply({}, values)"
    + "}");

Map<String, MapReduce> view = new HashMap<>();
view.put("get_numberOfSeasons", get_numberOfSeasonsMR);

designDocument.setViews(view);

dbClient.design().synchronizeWithDb(designDocument);

int count = dbClient.view("mydesign/get_numberOfSeasons").key("Arrow").queryForInt();