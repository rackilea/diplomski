BufferedReader br = new BufferedReader (new FileReader("b.txt")); 
String x;

while ((x = br.readLine()) != null)
{ // changed style, but otherwise fine
    System.out.println(x);
}