while (!br.contains("PERMANANT MARK BEFORE MY DESIRED INFO"))
      br.readLine(); //Which advances the line
String s = br.readLine(); //Repeat this till you get your info into s
//Trim functions (I used the </td> to my advantage)
s = s.split("THING NEXT TO INFO")[0[;
display.setText(s);