public static void main(String[] args){

    ...

    while(true){
        System.out.println("Welcome to StemCalc Z Edition(Integers only)!");

        ...

        while (choice !=99) {
            System.out.println("Do you want to continue calculating? [Y/N]:"); whatnow = scan.next().charAt(0);

            //insert some loop to ensure that the value of whatnow will be either Y or N

            if (whatnow == 'N' || whatnow == 'n') {
                System.exit(0);
            }
        }
    }
}