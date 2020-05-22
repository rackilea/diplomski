...
LinkedList<String> lines = new LinkedList<String>();
int numRows = 0, numCol = 0;
while((s = br.readLine()) != null) {
  numRows++;

  // Filling list
  lines.addLast(s);
}

int[][] mat = new int[numRows][];

for(int i = 0; i < lines.size(); i++) {
  mat[i] = lines.get(i).toCharArray();
}

lines.clear();