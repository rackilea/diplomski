public List<Integer> generateRandomArray(int n){
    ArrayList<Integer> list = new ArrayList<Integer>(n);
    Random random = new Random();

    for (int i = 0; i < n; i++)
    {
        list.add(random.nextInt(1000));
    }
   return list;
}