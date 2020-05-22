String str = "You can use a Matcher to find all matches to a regular repression #myString";
String[] arr=str.split(" ");
for(String i:arr){
     if(i.startsWith("#")){
          System.out.println(i);
      }
 }