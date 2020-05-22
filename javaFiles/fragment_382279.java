// Open and read text file
String inputFileName = "PodData2.txt";
FileReader fileReader = new FileReader("PodData2.txt");

// Create the FileReader object
try (BufferedReader br = new BufferedReader(fileReader);)
{    
    String[] strings = br.readLine().split(",");
    for (String str : strings)
    {
        switch (str.charAt(0))
        {
            case 'F':
                bayoneQueue.add(str);
                break;
            case 'T':
                baytwoQueue.add(str);
                break;
            case 'P':
                baythreeQueue.add(str);
                break;
            default:
                // In-case of invalid input
        }
    }
} 
catch(IOException ex)
{
    //handle exception;
}
finally
{
    fileReader.close();
}
System.out.println("Bay F: " + bayoneQueue.toString());
System.out.println("Bay T: " + baytwoQueue.toString());
System.out.println("Bay P: " + baythreeQueue.toString());