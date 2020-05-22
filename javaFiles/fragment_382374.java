public class tes 
{
    public static void main(String args[])
    {
        List<Integer> lList = new ArrayList<Integer>();

        lList.add(4);       
        lList.add(1);
        lList.add(7);
        lList.add(2);
        lList.add(9);
        lList.add(1);
        lList.add(5);

        Collections.sort(lList);

        for(int i=0; i<lList.size();i++ )
        {
            System.out.println(lList.get(i));
        }

    }
}