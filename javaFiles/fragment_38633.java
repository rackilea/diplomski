import java.util.ArrayList;
public class ReverseString
{
    public static void main(String args[])
    {
        String myName = "Here we go";
        ArrayList al = new ArrayList();
        al = recursiveReverseMethod(myName,al);
        al.trimToSize();
        StringBuilder sb = new StringBuilder();
        for(int i = al.size()-1; i>=0;i--)
        {
            sb.append(al.get(i)+" ");

        }
        System.out.println(sb);

    }
    public static ArrayList  recursiveReverseMethod(String myName,ArrayList al)
    {

        int index = myName.indexOf(" ");
        al.add(myName.substring(0, index));
        myName  = myName.substring(index+1);
        if(myName.indexOf(" ")==-1)
        {
            al.add(myName.substring(0));
            return al;
        }
        return recursiveReverseMethod(myName,al);

    }
}