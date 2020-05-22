int min = 2;
int max = 26;
int count = 10;
double inc = (max - min) / (double) (count - 1);
int[] weeks = new int[count];
double init = min;
for (int i = 0; i < count; i++) {
    weeks[i] = (int) Math.round(init);
    init += inc;
}
System.out.println(Arrays.toString(weeks));