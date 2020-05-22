FileWriter f0 = new FileWriter("output.txt");

String newLine = System.getProperty("line.separator");


for(i=0;i<10;i++)
{
    f0.write("Result "+ i +" : "+ ans + newLine);
}
f0.close();