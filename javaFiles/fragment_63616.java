PrintWriter f0 = new PrintWriter(new FileWriter("output.txt"));

for(i=0;i<10;i++)
{
    f0.println("Result "+ i +" : "+ ans);
}
f0.close();