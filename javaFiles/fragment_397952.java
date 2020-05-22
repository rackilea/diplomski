final JFileChooser fc = new JFileChooser("E://");
    int returnVal = fc.showOpenDialog(this);
    System.out.println(returnVal);

    if (returnVal == JFileChooser.APPROVE_OPTION) 
    {
        File file = fc.getSelectedFile();
        String p = file.getPath();
        try(BufferedReader bufRead = new BufferedReader(new FileReader(p)))
    {


        StringBuilder sb = new StringBuilder();
        String s = "";
        while((s=bufRead.readLine())!=null)
        {
            sb.append(s+" ");
        }
        String[] words= sb.toString().split(" ");
        for(String a:words)
        {
            System.out.println(a);// printing out each word
        }


    }
    catch(FileNotFoundException e)
    {
        System.out.println("File not found : "+e.getMessage());
    }
    catch(IOException ex)
    {
        System.out.println("Exception : "+ex.getMessage());
    }
    } 
    else 
    {
        System.out.println("Open command cancelled by user.");
    }