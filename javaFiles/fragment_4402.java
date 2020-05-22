int lengthArray = 5;
int[][] array = new int[lengthArray][lengthArray];
Random rnd = new Random();
array[0][0] = rnd.nextInt(7) + 4;
for (int i = 1; i < array.length; i++) {
    array[i][i] = rnd.nextInt(10) + (array[i - 1][i - 1]);
}

for (int i = 0; i < array.length; i++) {
    System.out.println(Arrays.toString(array[i]));
}