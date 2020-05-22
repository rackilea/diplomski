for (String base : login_elements) {
  String file = String.format("imagerepo/config/%s", base);
  if (s.exists(file) != null) {
    ...
  } else {
    ...
  }
}