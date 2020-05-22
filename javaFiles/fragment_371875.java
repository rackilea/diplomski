public static void main(String[] args) {

    // asking what symbol to use to print the eye(s) of the dice
    System.out.print("choose symbol to use for eyes: ");

    char ch;
    Scanner sc = new Scanner(System.in);

    ch = sc.findInLine(".").charAt(0);
    int dice = (int)(6*Math.random()) + 1;


    do{
        switch(dice % 6){
            case 0: System.out.println("1");
                    System.out.println(ch);
            break;
            case 1: System.out.println("2");
                    System.out.println(ch  + "\n\n " + ch);
            break;
            case 2: System.out.println("3");
                    System.out.println(ch + "\n " + ch + "\n  " + ch);
            break;
            case 3: System.out.println("4");
                    System.out.println(ch + " " + ch + "\n" + ch + " " + ch);
            break;
            case 4: System.out.println("5");
                    System.out.println(ch + " " + ch + "\n" + " " + ch + " \n"+ ch + " " + ch);
            break;
        }
        dice = (int)(6*Math.random()) + 1;
    }
    while(dice < 6);
    System.out.println("6");
       //         System.out.println(ch + " " + ch + "\n" + ch + " " + ch + "\n" + ch +
        //        " " + ch);
 }