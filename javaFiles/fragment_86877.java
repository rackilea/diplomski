import java.util.ArrayList; 

public class ParseParenthesizedString {
    public enum States { STARTING, TOKEN, BETWEEN }
    public static void main(String[] args)
    {
        ParseParenthesizedString theApp = new ParseParenthesizedString();
        theApp.Answer();
    }

    public void Answer()
    {
        String theString = 
           "content (content1 (content2, content3) content4 (content5 (content6, content7))";
        // wants:
        // ["content", "content1", "content2, content3", "content4", "content5", "content6, content7"]
        States state = States.STARTING;
        ArrayList<String> theStrings = new ArrayList<String>();
        StringBuffer temp = new StringBuffer("");

        for (int i = 0; i < theString.length() ; i++)
        {
            char cTemp = theString.charAt(i);
            switch (cTemp)
            {
                case '(':
                {
                    if (state == States.STARTING)  state = States.BETWEEN;
                    else if (state == States.BETWEEN)  {} 
                    else if (state == States.TOKEN )
                    {
                        state = States.BETWEEN;
                        theStrings.add(temp.toString().trim());
                        temp.delete(0,temp.length());
                    }
                    break;
                }
                case ')':
                {
                    if (state == States.STARTING) 
                    {  /* this is an error */ }
                    else if (state == States.TOKEN) 
                    {
                        theStrings.add(temp.toString().trim());
                        temp.delete(0,temp.length());
                        state = States.BETWEEN;
                    } 
                    else if (state == States.BETWEEN ) {}
                    break;
                }
                default:
                {
                    state = States.TOKEN;
                    temp.append(cTemp);
                }
            }
        }

        PrintArrayList(theStrings);
    }
    public static void PrintArrayList(ArrayList<String> theList)
    {    
        System.out.println("The ArrayList with " 
                + theList.size() + " elements:");
        for (int i = 0; i < theList.size(); i++)
        {
            System.out.println(i + ":" + theList.get(i));
        }
    }
}