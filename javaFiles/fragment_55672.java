final char[][] cleanMaze = readFromFile(); // never modify this again

char[][] copyMaze = new char[size][size];
for (int i = 0; i < size; i++) {
  System.arraycopy(cleanMaze[i], 0, copyMaze[i], 0, size);
}