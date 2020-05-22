public class Tracker {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File f =new File("D:/Tracker.csv");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String s ;
        while ((s=br.readLine())!=null)
        {
            System.out.println(s);
        }
        br.close();
    }
}