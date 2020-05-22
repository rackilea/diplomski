for (String line1 = reader.readLine(); line1 != null; line1 = reader.readLine()) {
      String[] splitString = line1.split(":");
      splitString = splitString[1].split(",");
      String[] textline = new String[splitString.length];
      for (int i = 0; i < textline.length; ++i) {
          textline[i] = splitString[i];
      }
      arrays.add(textline);
  }