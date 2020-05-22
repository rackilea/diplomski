if (command.equals("diary"))
{
    String stuff;
    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\text.txt")); //you don't need to create a File object, FileWriter takes a string for the filepath as well
    Scanner scanner =null;
    while (scanner.hasNextLine())
    {
        stuff = scanner.nextLine();

        try {
            writer.write("Diary info: " + stuff);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    writer.close();

}