InputStreamReader st = new InputStreamReader(System.in);
BufferedReader bf = new BufferedReader(st);

String words;
String[] split;

do
{
   System.out.println("Enter 3 words");
   words = bf.readLine();
   split = words.split(" ");

}while(split.length != 3);