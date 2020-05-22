public class NewString
{
    public static String S1;
    public static int a=0;
    public static String ar[];
    public static int lnum=0;
    public static String line=null;

    public String read() throws IOException
    {
    FileReader fr= new FileReader("read_listflow.txt");
    BufferedReader br=new BufferedReader(fr);
    while ((line=br.readLine())!=null)
    {
        lnum=lnum+1;
    }

    FileReader fr1= new FileReader("read_listflow.txt");
    BufferedReader br1=new BufferedReader(fr1);
    ar=new String[lnum];
    while ((line=br1.readLine())!=null)
    {
        ar[a]=line;
        a=a+1;
    }
    S1 = ar[1];
    return S1;
    }

}