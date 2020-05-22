public static void main(String[] args){
    Scanner sc=new Scanner (System.in);
    int choice = 0;
    do {
        System.out.println("This is a program to encode or decode bytes based on RLE ALgorithm" +
                "\n (o_O) Choices are: " +
                "\n 1: Press 1 to enter the encode mode" +
                "\n 2: Press 2 to enter the decode mode" +
                "\n 3: Press 3 to Exit!");
        boolean error = true;
        while (error){
            try {
                if(sc.hasNextInt()) choice=sc.nextInt();
                else {
                    sc.next();
                    continue;
                }
                error = false;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("invalid type or format!");
            } catch (NoSuchElementException e) {
                System.out.println("no such");
            }
        }
        switch(choice){

            case 1 :
                System.out.println("entering the encode mode!");
                System.out.println(input(sc));
                break;
            case 2 :
                //countAndDecode(input(sc));
                break;
            case 3 :
                System.out.println("exiting...");
                break;
            default :
                System.out.println("please enter a valid option and valid format!");
        }

    } while (choice!=3);
    sc.close();
}