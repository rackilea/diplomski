class TwentyOnly{
    private static List<TwentyOnly> twenty= new ArrayList(20);

    private static int counter=0;
    private TwentyOnly(){
    }
    public static synchronized TwentyOnly  borrow(){
      if(counter<20){
        twenty.add(0,new TwentyOnly());
        counter++;
        return twenty.get(0);
      }
      throw new RUntimeException("All Allowed instances allowed");
    }

    public static synchronized void returnObject(TwentyOnly t){
         twenty.remove(t);
         counter--;
    }
}