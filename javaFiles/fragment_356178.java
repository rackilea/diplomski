for(int i=0; i<files.length-1; i++) 
    for(int j=i+1; j<files.length; j++)
        if(FileUtils.contentEquals(files[i], files[j]))
            System.out.println("file #" + i + " and file #" + j + " are identical.";
        else
            System.out.println("file #" + i + " and file #" + j + " are different.";