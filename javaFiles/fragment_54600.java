public class Election {
    private final int VOTES_NUM = 1;
    private int v1,v2,v3,v4,v5,d;

    public Election() {
        v1=v2=v3=v4=v5=d=0;
        //print now, just to show that all variables = 0
        testResult();
    }

    //Simple method that prints value of each variable. We use this for testing
    public void testResult(){
        System.out.println("v1 = "+v1);
        System.out.println("v2 = "+v2);
        System.out.println("v3 = "+v3);
        System.out.println("v4 = "+v4);
        System.out.println("v5 = "+v5);
        System.out.println("d = "+d);
    }

    private int getInput(){
       //First of all, we need a Scanner to take user input. 
       //You do that in your own code too. We simply move it in this method instead.
        Scanner input = new Scanner(System.in);

        //You also need variable to hold the user input. 
        //(Always give meaningful names to all entities)
        int userInput;

        System.out.print("Please enter vote number here: ");

        //the next part has to be in a try-catch block, 
        //to avoid exceptions like InputMismatchException, etc..
        try{
            //Get user input
            userInput = input.nextInt();
        }
        //If user enters letter, or symbol, or something else that isn't an integer,
        //then inform them of the mistake they made and recursively call this method,
        //until they get it right!
        catch (InputMismatchException ime){
            System.out.println("Please enter only a single number");
            return getInput();
        }

        //If all goes well, return the user input
        return userInput;
    }

    public void getVotes() {
        //'VOTES_NUM' is a constant that defines the times the 
        //loop will iterate (like Macros in 'C')
        for(int x=0; x<VOTES_NUM; x++)
            int n = getInput();
        //then let the switch statement increment one of the variables
        switch(userInput) {
            case 1: ++v1; break;
            case 2: ++v2; break;
            case 3: ++v3; break;
            case 4: ++v4; break;
            case 5: ++v5; break;
            default: ++d; break;
        }
    }
}