StringBuffer jb = new StringBuffer();
  String line = null;
  try {
    BufferedReader reader = request.getReader();
    while ((line = reader.readLine()) != null)
      jb.append(line);
  } catch (Exception e) { /*report an error*/ }

  try {
    JSONObject jsonObject = JSONObject.fromObject(jb.toString());
  } catch (ParseException e) {
    // crash and burn
    throw new IOException("Error parsing JSON request string");
  }