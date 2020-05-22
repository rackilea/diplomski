int temp = solutionFile.nextInt();

for(int i = 8; i > 0; i--) {
   int cell = temp / (10 * i);
   data.get(k).add(cell);
}

//add the last cell
int cell = temp % 10;
data.get(k).add(cell);