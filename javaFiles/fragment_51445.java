File file = new File("d:\\abc"); //This just creates a file object
    System.out.println(file.exists()); //This will return false
    System.out.println(file.isFile()); //This will return false
    System.out.println(file.isDirectory()); //This will return false

    file.mkdir(); //This will create a directory called abc
    System.out.println(file.exists()); //This will return true because a directory exists
    System.out.println(file.isFile()); //This will return false because we have created a directory called abc not a file
    System.out.println(file.isDirectory());//This will return true because we have just created a directory called abc