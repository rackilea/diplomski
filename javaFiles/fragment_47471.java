public static int fileCount(File directory) throws NullPointerException
{
    Stack<File> fileStack = new Stack<File>();
    File[] potentialDirectories = directory.listFiles();

    for (File file: potentialDirectories)
    {
        fileStack.push(file);
    }

    int totalSize = 0;

    while (!fileStack.isEmpty())
    {   
        File poppedElement = (File)fileStack.pop();


        if(poppedElement.isFile())
        {
            totalSize++;
        }
        else
        {
            potentialDirectories = poppedElement.listFiles();

            for (File file: potentialDirectories)
            {
                fileStack.push(file);
            }
        }
    }

    return totalSize;
}