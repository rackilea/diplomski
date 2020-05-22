MultipartFormData body = request().body().asMultipartFormData();
List<FilePart> files = body.getFiles();
// store files etc.
Map<String, String[]> asFormUrlEncoded = request().body().asMultipartFormData().asFormUrlEncoded();
String[] descriptionParams  = asFormUrlEncoded.get("description");
// save descriptions