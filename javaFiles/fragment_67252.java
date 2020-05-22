try{
        writeToFile = new Formatter("TotalSalary.txt");
    }
    catch (SecurityException se) {
        System.out.println("You do have access to this file");
        System.exit(1);
    }
    catch (FileNotFoundException fnfe) {
        System.out.println("Error Creating File");
        System.exit(1);
    }
while(sc.hasNext()){