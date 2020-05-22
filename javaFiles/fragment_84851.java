public class DataInsideArrays 
{ 
    public static DataInputStream a = new DataInputStream(System.in) 
    public static int size = 100; // now you only change this number and everything works
    public static int[] productNumbers = new int[size];
    public static String[] productNames = new String[size];
    public static int[] productPrices = new int[size];

    public static void main(String args[]) throws Exception 
    { 

        int prodnumIndex = 0; // index for tracking product numbers
        int prodnameIndex = 0; // index for tracking product names
        int prodpriceIndex = 0; // index for tracking product prices
        for(int x = 0; x < size; x++)
        {        
        // ... your code...

        // ...

        int prodNum = Integer.parseInt(a.readLine());
        // check if we didn't reach our maximum size
        if(prodnumIndex < productNumbers.length) {
            productNumbers [prodnumIndex] = prodnum;
            prodnumIndex++; // increment
        } else {
            System.out.println("Cannot add product number. Reached maximum amount.");
        }


        // ...

        String prodName = a.readLine();
        // check if we didn't reach our maximum size
        if(prodnameIndex < productNames.length) {
            productNames [prodnameIndex] = prodName ;
            prodnameIndex++; // increment
        } else {
            System.out.println("Cannot add product name. Reached maximum amount.");
        }

        // ...

        int prodPrice = Integer.parseInt(a.readLine());
        // check if we didn't reach our maximum size
        if(prodpriceIndex < productPrices.length) {
            productPrices [prodpriceIndex] = prodPrice ;
            prodpriceIndex++; // increment
        } else {
            System.out.println("Cannot add product number. Reached maximum amount.");
        }   

        // ... 

        }