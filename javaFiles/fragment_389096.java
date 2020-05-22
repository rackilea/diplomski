String shortenedPath(String path) {
  File complete = new File(path);
  String parentDir = complete.getParent().getName();
  File shortened = new File(parentDir, complete.getName());
  return shortened.toString();
}