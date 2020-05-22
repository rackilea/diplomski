Pattern pattern = Pattern.compile("\\d{4}"); 
String [] numArray = {"1234", "-1234" , "abcd", "12ab","2345","1a34"};

for(String num: numArray){
    if(pattern.matcher(num).matches()){
         System.out.print(num + " ");
    }
}