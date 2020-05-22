public static void main(String [] args) throws Exception{    // just for the example

    // locate the file
    File fileOne = new File("fileOne.txt");
    FileReader inputStream = new FileReader(fileOne);
    BufferedReader reader = new BufferedReader(inputStream);


    // create a LinkedList to hold the data read
    List<Integer> numbers = new LinkedList<Integer>();

    // prepare variables to refer to the temporary objects
    String line = null;
    int number = 0;

    // start reading
    do{
        // read each line
        line = reader.readLine();

        // check if the read data is not null, so not to use null values
        if(line != null){
            number = Integer.parseInt(line);
            numbers.add(number*10);
        }

    }while(line != null);

    // free resources
    reader.close();

    // check the new numbers before writing to file
    System.out.println("NEW NUMBERS IN MEMORY : "+numbers);

    // assign a printer
    PrintWriter writer = new PrintWriter(fileOne);

    // write down data
    for(int newNumber : numbers){
        writer.println(newNumber);
    }

    // free resources
    writer.flush();
    writer.close();
}