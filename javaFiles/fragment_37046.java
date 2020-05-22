public static void main(String args[]) {

  String input = new String("2 Marine Cargo       14,642 10,528       16,016 more text 8,609 argA 2,106 argB");
  System.out.println("Return Value :" );      

  Pattern pattern = Pattern.compile("[0-9,]+|[a-zA-Z]+ *[a-zA-Z]*");

  ArrayList<String> result = new ArrayList<String>();
  Matcher m = pattern.matcher(input);
  while (m.find()) { 
         System.out.println(">"+m.group(0)+"<");  
         result.add(m.group(0));

   }
}