String text = "DESTINATION: 71222222 PRIORITY: urgent AUTRE: rien";

String[]lines = text.replace(": ", ":").split(" ");     
String[]values = new String[lines.length];
int i=0;
for(String line : lines){
   values[i++] = line.split(":")[1];
}
System.out.println(Arrays.toString(values));