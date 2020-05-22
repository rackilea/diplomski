File f= new File("WordDict.txt");
    if(!f.exists())
        try {
            f.createNewFile();
        } 
        catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    try {
        FileInputStream Fis=new FileInputStream(f);
        Scanner sc = new Scanner(Fis);
        System.out.println("Check outside nextline");