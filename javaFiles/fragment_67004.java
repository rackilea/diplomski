ArrayList<Integer> arrayRandom = new ArrayList<Integer>(n);

Random rand = new Random();
rand.setSeed(System.currentTimeMillis());
for (int i=0; i<n; i++)
{
    Integer r = rand.nextInt() % 256;
    arrayRandom.add(r);
}