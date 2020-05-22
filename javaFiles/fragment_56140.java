public static double [] loadGravityData( ) throws IOException
{
 Scanner sc=new Scanner(new File("gravity1.txt"));
    List<Double> arr=new ArrayList<>();
    while(sc.hasNext()){
        arr.add(sc.nextDouble());
    }
    double doubleArr[]=new double[arr.size()];
    for (int i=0;i< arr.size();i++) {
        doubleArr[i]=arr.get(i);
    }
  return   doubleArr;
}