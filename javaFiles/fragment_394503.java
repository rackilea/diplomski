if (url.getScheme().equalsIgnoreCase("file")) {
  File file = new File(url.toURI());
  return Response.ok(file).header("Content-Length", file.length()).build();
} else {
  return Response.seeOther(url);
}