List<ArrayList<File>> filesList = new ArrayList<ArrayList<File>>();
    //add objects to filesList here

    Iterator<ArrayList<File>> filesListIterator = filesList.iterator();

    while(filesListIterator.hasNext())
    {
        ArrayList<File> files = filesListIterator.next();

        Iterator<File> filesIterator = files.iterator();

        while(filesIterator.hasNext())
        {
            File file = filesIterator.next();
            //do your own logic here;
        }
    }