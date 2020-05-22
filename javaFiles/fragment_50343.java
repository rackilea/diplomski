StringBuilder sb = new StringBuilder();
int state = 0;
while (sc1.hasNextLine()) {
  String line = sc1.nextLine();
  if (line.contains("How To Fix:")) {
    state = 1;
  }
  if (state == 1) {
    sb.append(line);
  }
  if (line.contains("Related Links:")) {
    state = 0;
  }
}