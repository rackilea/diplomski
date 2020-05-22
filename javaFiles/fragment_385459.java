String[] lines = new String[n];
int i = 0;
while(!file.eof()) {
  String line = file.readLine();
  lines[i] = line;
  i = (i + 1) % n;
}

for(int j = 0; j < n; j++) {
  if (lines[i] != null) {
    System.out.println(lines[i]);
  }
  i = (i + 1) % n;
}