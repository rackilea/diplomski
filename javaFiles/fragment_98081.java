import java.util.*;

class Main
{
    static HashMap<String,Integer> map;
    static ArrayList<HashSet<Integer>> list;

    static boolean check(String id1,String id2)  //To check if a connection exists or not
    {
        int index1=map.get(id1);
        int index2=map.get(id2);

        return list.get(index1).contains(index2);
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        ArrayList<String> ids=new ArrayList<String>();
        ids.add("A");ids.add("B");ids.add("C");ids.add("D");  //Taking all possible IDs

        map=new HashMap<String,Integer>();

        int given_id=0;

        for(String id:ids)
        {
            if(!map.containsKey(id))
            {
                map.put(id,given_id);          //Assigning each String a unique ID
                given_id++;
            }
        }

        list=new ArrayList<HashSet<Integer>>(); //ArrayList of HashSet is used to store the connections

        for(int i=0;i<given_id;i++)
        {
            list.add(new HashSet<Integer>());
        }

        //Now for example, we store the connections in HashSet

        String connections="A B A C A D B A B D C A D A D B"; //You can change the following loop as per your need
        String arr[]=connections.split(" ");

        for(int i=0;i<arr.length;i+=2)
        {
            int index1=map.get(arr[i]);
            int index2=map.get(arr[i+1]);

            list.get(index1).add(index2);       //Adding connection in both IDs
            list.get(index2).add(index1);
        }

        if(check("A","D"))
            System.out.println("A and D are friends!");
        else
            System.out.println("No, A and D are not friends!");

        if(check("C","D"))
            System.out.println("C and D are friends");
        else
            System.out.println("No, C and D are not friends!");
    }
}