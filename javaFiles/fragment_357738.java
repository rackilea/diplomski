public static void main(String[] args) {

    Scanner scn=new Scanner(System.in);     
    System.out.println("enter the sample string ");     
    String sampleString=scn.next();
    int leftBracketCounter=0;
    int rightBrackerCounter=0;
    for(int i=0;i<sampleString.length();i++)
    {

        if(sampleString.charAt(i)=='(')
        {
            leftBracketCounter++;
        }
        else
            if(sampleString.charAt(i)==')')
            {

                rightBrackerCounter++;
                // System.out.println("first braket encounterd @ loc "+i);
            }
    }


if(leftBracketCounter==rightBrackerCounter)
{
    System.out.println("balanced String entered");

}
else {
    System.out.println("not a valid input");

}

    ArrayList< String>alist=new ArrayList<>();  
    int last_bracket_loc=0;

    for(int i=0;i<sampleString.length();i++)
    {
        if(sampleString.charAt(i)=='(')

        {
            alist.add("(");         
            }

        else if (sampleString.charAt(i)==')') {     
            int alist_size=alist.size();
            alist.remove(alist_size-1);
            last_bracket_loc=i;

        }           
    }

String temp = sampleString.substring(1,last_bracket_loc);
System.out.println("finally the data remained is "+ temp);

}
}