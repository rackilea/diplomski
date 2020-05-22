private void magic()
{
Random generator = new Random();
        SIZE = generator.nextInt(30) + 1;
        MAX = generator.nextInt(30) + 1;
        toSort = new int[SIZE];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = generator.nextInt(MAX);
        }

}