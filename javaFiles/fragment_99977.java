//I used 3 integers just for demonstration purpose 
    int casevar1, win1, loose1,casevar2, win2, loose2;
    public static void main(String[]arghs){

        System.out.println("Make a choice : (1), (2), (3)");
        //validation is a scanner already declare elsewhere
        n = validation.nextLine();

        switch (n) {
            case "1":
                //assign values 
                casevar1 =7;  win1 =9; loose1 =0;
                play(casevar1, win1, loose1); //pass appropriate variables to play method
                break;
            case "2":
                //assign values 
                casevar2 =17;  win2 =8; loose2 = 4;
                play(casevar2, win2, loose2); //pass appropriate variables to play method
                break;
            case "3":
               //do like case "1" / case "2" 
                break;
            default:
                System.out.println("invalid");
        }//end of switch
    }

    //an example of a play method recieving 3 integers. 
    public static void play(int casevar, int win, int loose){

        System.out.print("Did you win? ( (y)es or (n)o ) ");
        choice = validation.nextLine();
        //follow Aku Nour's answer
    }