List<int[]> loadGuessList = new ArrayList<>();

  while ((line = reader.readLine()) != null) {
    int [] digits = new int[4];
    for (int i = 0; i < line.length(); i++) { //Assuming line.length() will be 4
        digits[i] = line.charAt(i) - '0';
    }
    loadGuessList.add(digits);
}