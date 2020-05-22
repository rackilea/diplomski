File[] fileArray = folder.listFiles();
List<String> files = new ArrayList<String>(); // <-- A list of files
for (int i = 0; i < fileArray.length; i++)
{
    if (fileArray[i].isFile())
    {
        String fileName = fileArray[i].getName();
        if (fileName.endsWith(".csv"))  // <-- does it end in ".csv"?
        {
            files.add(fileName);       // <-- Add the file to the List.
        }
    }
}
// Now files contains the matching fileNames...
for (String fileName : files) {
    // Add code here to use each fileName
    System.out.println(fileName.replace(".csv", ""));
}