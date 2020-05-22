public static void main(String args[])throws IOException
{
    boolean mSelected = false;

    ...

    while(choice != 'E')
        {
        switch (choice)
        {
            ...

            case 'M':
            mSelected = true;
            input2.quizMarking();
            break;

            case 'S':
            if (mSelected) {
                input2.stuStatsPrint();
            } else {
                System.out.println("Please mark the answers before inputting statistics");
            }
            break;

            case 'Q':
            if (mSelected) {
                input2.quesStatsPrint();
            } else {
                System.out.println("Please mark the answers before inputting statistics");
            }
            break;

            ...
        }

    ...