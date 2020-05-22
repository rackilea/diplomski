public class SpecialComparator implements Comparator<String> {

   @Override
    public int compare(String arg0, String arg1) {
     // TODO Auto-generated method stub
     String []words1=arg0.split(" ");
     String [] words2 = arg1.split(" ");
     int i = 0;

        if (words1[i].hashCode()>words2[i].hashCode()){
            return 1;
        }
        else if (words1[i].hashCode()<words2[i].hashCode()){
            return -1;
        }
        else if (words1[i].hashCode()==words2[i].hashCode())
            return compare(arg0.substring(i+1, arg0.length()), arg1.substring(i+1,arg1.length()));
        else if (i == Math.min(words1.length,words2.length)-1 && Math.min(words1.length,words2.length) == words1.length){
            return -1;
        }
        else if (i == Math.min(words1.length,words2.length)-1 && Math.min(words1.length,words2.length) == words2.length){
            return 1;
        }
        else if (i == Math.min(words1.length,words2.length)-1 && words1.length == words2.length){
            return 0;
        }
        else{
            return 0;
        }


   }


   public static void main (String[] args){
    ArrayList<String> input = new ArrayList<String>();
    SpecialComparator a = new SpecialComparator();
    input.add("road 21");
    input.add("road 1");
    input.add("road 186");
    input.add("road +21 / 23");
    input.add("road +21 / 19");
    input.add("another road 21");
    input.add("another road 1");
    Collections.sort(input,a);
    for (String ans : input){
        System.out.println(ans);
    }

  }



 }