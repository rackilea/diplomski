File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null)
        {
            for (int i = 0; i < listOfFiles.length; i++)
            {                    
                if( !listOfFiles[i].isDirectory() ){   // if not a directory...
                    logger.debug("File name=" + listOfFiles[i].toString() + " is Deleted!");
                    listOfFiles[i].delete();
                }
            }
        }