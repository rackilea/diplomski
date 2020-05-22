List<string> asu = Arrays.asList("M1","M1","M1","M3","M4","M5","M1","M1","M1","M4","M5","M5");
List<string> rzs = Arrays.asList("M1","M2","M3","M4","M5",
"M1M2","M1M3","M1M4","M1M5","M2M3","M2M4","M2M5","M3M4","M3M5","M4M5"
,"M1M2M3","M1M2M4","M1M2M5","M1M3M4","M1M3M4","M1M4M5","M2M4","M2M5");
public static void main(String[] args) {
work bebebe = new work();
bebebe.mywork();
}

public static void mywork() {
   ArrayList<String> tmp1 = new ArrayList<String>();  
   ArrayList<String> tmp2 = new ArrayList<String>();  
   System.out.println((rzs));
   System.out.println((asu));
   for (String curr : asu){
     for (String currRzs : rzs){
       if (currRzs.contains(curr)) {
          System.out.println(" item("+curr+") in ASU found contained in ("+currRzs+") in RZS");

      if(tmp1.contains(curr) == false)
         tmp1.add(curr);

      if(tmp2.contains(currRzs) == false)
         tmp2.add(currRzs);
       }
      } 
    }

   for (String curr : tmp1){
      asu.remove(curr);
   }

   for (String curr : tmp2){
      rzs.remove(curr);
   }
}