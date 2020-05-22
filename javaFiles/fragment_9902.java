int[] backing = new int [10];
for (int j = 0; j < N; j++) {
    int x = scanner.nextInt();
    backing[x]++;
}
//At this point, you have a backing array with the frequency of each integer