public void read()
    {
        try
        {
            Scanner scanner = new Scanner
                    (new File("data.in"));
            while (scanner.hasNextLine()) 
            {
                System.out.println(scanner.nextLine());
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }