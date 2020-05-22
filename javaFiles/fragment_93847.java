try
{
    Scanner sc = new Scanner(ta.getText());
    String s="";
    for(int i=1; i<=100; i++)
    {
        s+=sc.nextLine()+"\r\n";
        if(i%30==0)
        {
            File f = new File("File"+(i/30)+".txt");
            f.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(s);
            bw.close();
            s="";
        }
    }
    File f = new File("File4.txt");
    f.createNewFile();
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    bw.write(s);
    bw.close();
}catch(Exception e){}