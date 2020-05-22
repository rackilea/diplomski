int freq = 0;
String s = "Happy days are here again";
char a = 'a';


//processing
for(int i = 0;i<=s.length()-1;i++){
    if(s.charAt(i)==a){
        System.out.print(i + ",");
    }//end of if

}//end of for
System.out.println(freq);