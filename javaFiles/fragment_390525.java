public static List<String> lst0 = new ArrayList<String>();
    public static List<String> lst1 = new ArrayList<String>();

    public static void main(String[] args) throws NoSuchElementException, NoSuchFieldException, IllegalAccessException
    {

       lst0.add("abc");       
       lst1.add("def");

       Class thisClass = SOTest.class;
       for(int i = 0; i < 2; i++)
       {
           Field field = thisClass.getField("lst" + i);
           List<String> lst = (List<String>) field.get(new ArrayList<String>());
           System.out.println(lst.get(0));
       }
    }