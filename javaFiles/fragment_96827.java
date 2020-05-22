private static float parse(String s) {
   String str = s.substring(s.indexOf('(')+1, s.length()-1);
   String[] numbers = str.split(",");

   return Float.parseFloat(numbers[1]) - Float.parseFloat(numbers[0]);

}

public static void main(String[] args) {
    String s = "sil(0.14,0.25) in(0.25,0.82) order(0.82,1.03) to(1.03,1.17)            entertain(1.17,1.94) the(1.94,2.04) people(2.04,2.41) who(2.41,2.54) are(2.54,2.6) listening(2.6,3.13) to(3.13,3.29)";

    String[] sArray = s.split(" ");

    for(String str : sArray){
       String head = str.substring(0, str.indexOf('('));
       System.out.println(head + "=" +parse(str));
    }

}