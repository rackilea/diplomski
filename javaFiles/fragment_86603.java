public static void main (String[] args) throws java.lang.Exception
{

   List<List<Integer>> myValues = getValues();
   System.out.println(myValues);

}

public static List<List<Integer>> getValues() {
   List<List<Integer>> lst = new ArrayList<>();
   List<Integer> vals = new ArrayList<>();

   vals.add(1);
   vals.add(2);
   lst.add(vals);

   vals = new ArrayList<>();
   vals.add(5);
   vals.add(6);
   lst.add(vals);       

   return lst;
}