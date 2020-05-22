PathProperties pathProperties = PathProperties.parse("id,name");
query.apply(pathProperties);
// fetch only id and name
List<App> list3 = query.findList();

// json output only id and name
JsonWriteOptions options2 = new JsonWriteOptions();
options2.setPathProperties(pathProperties);
String json2 = jsonContext.toJson(list3, options2);