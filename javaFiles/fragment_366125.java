public String getBundle(String key, Object... params) {
  String message = null;
  try {
    if (params == null) {
      message = resourceBundle.getString(NULL_MSG);
    } else {
      message = MessageFormat.format(resourceBundle.getString(key), params);
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  return message;
}