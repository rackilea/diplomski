public class Test {
public static void main(String[] args) {

int count1=0;
int chars_not_x=0 ;

String str = "xyz xyxzghz zyxzz";
String[] words = str.split("\\s");

for(int m=0; m<words.length; m++){

count1 = 0;    // Add this

System.out.println(words[m]);

System.out.println("Total characters in the word: "+words[m].length());
for(int n=0; n<words[m].length(); n++){
if(words[m].charAt(n)=='x'){count1++;}}

       System.out.println("Number of x :"+count1);
       chars_not_x= words[m].length()- count1; 
       System.out.println("Chars other than x: "+chars_not_x);
       System.out.println("\n");


}} }