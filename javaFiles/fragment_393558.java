public static void main(String[] args) {
     String toConvert= "8011411110311497109109105110103";
     String result="";
     while(toConvert.length()>0){
         String digits=toConvert.substring(0, 2);
         int num=Integer.valueOf(digits);
         if(('A'<=num&&num<='Z')||('a'<=num&&num<='z')){
             toConvert=toConvert.substring(2);
         }
         else{
             digits=toConvert.substring(0, 3);
             num=Integer.valueOf(digits);
             toConvert=toConvert.substring(3);
         }
         String letter = String.valueOf((char) num);
         result+=letter;
     }
     System.out.println(result);
}