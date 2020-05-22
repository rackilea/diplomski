private static int countQuestions() throws FileNotFoundException{
    int counter = 0;
    Scanner file = new Scanner (new File("testBank.txt"));
    while(file.hasNextLine()){
        try
        {
            // check if line empty
            String text = file.nextLine();

            while(text.equals(" ")){
                    file.nextLine();
            }
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();
            file.nextLine();

            counter++;
        }
        catch(NoSuchElementException e)
        {
            //Found End of File
        }
    }
    return counter;
}