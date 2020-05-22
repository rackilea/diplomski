File yearsDirs = new File("Registers"); 

    if (!yearsDirs.exists()){ //Create "Registers" when it does not exists.
        yearsDirs.mkdir();
    }

    File[] dirs = yearsDirs.listFiles();

    for (File dir : dirs) {
        if (dir.isDirectory()) {
            System.out.print("Registers ");
        } else {
            System.out.print("Register ");
        }
        try {
            System.out.println(dir.getName());
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }