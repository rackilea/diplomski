String savedString = prefs.getString("string", "");
StringTokenizer st = new StringTokenizer(savedString, ",");
Boolean[] savedList = new Boolean[10];
 for (int i = 0; i < 10; i++) {
    savedList[i] = Boolean.valueOf(st.nextToken();
  }