while(filesListIterator.hasNext())
    {
        ArrayList<File> files = filesListIterator.next();

        for(int i=0;i<files.size()-1;i++)
        {
            File firstFile = files.get(i);//get a file

            File secondFile = files.get(i+1);//get the next file

            compareFiles(firstFile,secondFile);//this is your defined   
                                             //method for compare
        }
    }