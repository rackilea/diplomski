import java.util.ArrayList;

public class abc
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<10;i++) {
            a.add(new ArrayList<Integer>);
            for(int j=0;j<10;j++)
            { 
               (a.get(i)).add(j,j);
            }
       }
    }
}