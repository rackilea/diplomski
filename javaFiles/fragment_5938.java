try {
        BufferedWriter out = new BufferedWriter(new FileWriter("sample.txt"));
        out.write(info);
        out.close();
    }
    catch (IOException e)
    {
        System.out.println("Exception ");       
    }