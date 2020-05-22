while ((line = br.readLine()) != null) {
  line = line.substring(line.indexOf('(')+1, line.lastIndexOf(')'));
  String[] parts = line.split(",");
  for (int i = 0; i<parts.length; i++) {
    array[lineCount][i] = Integer.parseInt(parts[i]);
  }
  lineCount++;
}