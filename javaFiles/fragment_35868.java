try
    {
        //regex for matching only numbers and dot
        Pattern p = Pattern.compile("[^0-9.]");
        scanner = new Scanner(new FileReader(FILE_PATH)).useDelimiter(p);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if(!next.equals("") && !next.equals(".")) {
                System.out.println(next);
            }
        }
    }
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
    }
    finally
    {
        if (scanner != null)
            scanner.close();
    }