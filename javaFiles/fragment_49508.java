String input = "0.123 0.234 0.456";  // <= string from DB cell
String[] ss = input.split("\\s+");   // <= split using whitespaces as splitter
float[] f = new float[ss.length];    
int i = 0;
for(String s : ss) {                 // <= iterate over separate values
     try {
          f[i++] = Float.parseFloat(s);
     } catch (RuntimeException e) {
          System.out.println(s + " cannot be converted to float");
     }
}