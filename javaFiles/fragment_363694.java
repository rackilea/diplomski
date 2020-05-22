BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
String line;

while ((line = br.readLine()) != null)
{
    ...
    for(int i=0;i<3;i++){ br.readLine(); }
}

br.close();