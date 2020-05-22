for(int i=0;i<customerList.length;i++)
{   
    String line1 = scan1.nextLine();
    Scanner scan2 = new Scanner(line1);
    scan2.useDelimiter("\t");

    // ... a bunch of code deleted for brevity's sake
    // ... etc...

    scan2.close();
} // end of for loop