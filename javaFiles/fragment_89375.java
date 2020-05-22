final List<String[]> userData = new LinkedList<String[]> ();

try
    {
        File file = new File("C:/Users/Sean/Documents/Programming assigment/Users.csv");
        BufferedReader bufRdr  = new BufferedReader(new FileReader(file));      
        String lineRead = bufRdr.readLine();
        while(lineRead != null)
        {
            this.userData.add (lineRead.split(","));
        }
        bufRdr.close();
    }
    catch(Exception er){
        System.out.print(er); 
        System.exit(0);
    }