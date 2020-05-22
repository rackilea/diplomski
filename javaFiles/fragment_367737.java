public class IPAddressLookup {
ArrayList<String[]> ip = new ArrayList<>();
IPAddressLookup()   //Constructor
{
    int Width = 0, Height = 0;

    try
    {
        File fileA = new File("ClassA.txt");
        BufferedReader bra = new BufferedReader(new FileReader(fileA));

        String line = "";
        String[] str;

        while((line = bra.readLine()) != null )
        {
            str = line.trim().split(", ");
            ip.add(str);
            Width = str.length;
            Height++;
        }

        String [][] ClassATable = new String[Height][Width];

        for(int i=0 ; i<ip.size();i++){
            String[] temp = ip.get(i);
            for(int j=0;j<temp.length;j++){
                ClassATable[i][j] = temp[j];
            }
        }


        for(int i = 0; i < Height; i++)
            for(int j = 0; j < Width; j++)
                System.out.println(ClassATable[i][j]);

        System.out.println("The text file contains:");
        System.out.println("Row : " +Height);
        System.out.println("Column : " +Width);
    }
    catch(IOException e)
    {
        System.out.println("Error: File not found.");
    }
}

public static void main(String args[])
{
    IPAddressLookup acnl1 = new IPAddressLookup();
}