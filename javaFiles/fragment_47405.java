public Catalog loadCatalog(String filename) 
    throws FileNotFoundException, 
           IOException, 
           DataFormatException
{
    String line = "";

    BufferedReader stdIn = new BufferedReader(new FileReader("catalog.dat"));
    BufferedReader input = new BufferedReader(new FileReader(stdIn.readLine()));

    while(!stdIn.ready())
    {
        line = input.readLine();

        if(line.startsWith("Product"))
        {
            readProduct(line);
        } 
        else if(line.startsWith("Coffee"))
        {
            readCoffee(line);
        }  
        else if(line.startsWith("Brewer"))
        {
            readCoffeeBrewer(line);
        }
    }

    return null;
}