String line = solutionFile.next();

for(int i = 0; i < line.length; i++) {
   Integer cell = Integer.parseInt(line.substring(i, i+1));
   data.get(k).add(cell);
}