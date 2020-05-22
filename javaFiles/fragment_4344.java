BufferedReader br = null;
String line = "";
int i=0;
double originalArray[] = new double[20]; 
br = new BufferedReader(new FileReader(file));
br.readLine();//skip the first line to get rid of header…  

while ((line = br.readLine()) != null && i<originalArray.length) {
    String[] readlineArray = line.split(";");
    originalArray[i] = Double.parseDouble(readlineArray[0]);
    originalArray[i+1] = Double.parseDouble(readlineArray[1]);
    i+=2;
}
System.out.println(Arrays.toString(originalArray));