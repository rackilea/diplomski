public static void main(String[] args) {
    // TODO Auto-generated method stub

    int oddCounter=0; 
    int evenCounter=0;

    Scanner scan = new Scanner(System.in);

    System.out.println("How many random numbers do you want? (0-999)");
    int numb = scan.nextInt();

    System.out.println("Your random numbers:");

    int array[] = new int[numb];

    for(int i =0; i < numb; i++){

        array [i]  = (int) (0 + 1000  * Math.random()); 

        System.out.print(array[i]);
        System.out.print(" ");


    }
    System.out.println();
    System.out.println();


    for(int j =0; j < numb; j++){

        if(array[j] %2 == 0){
            evenCounter++;

        }

    }

    System.out.println("Dessa " + evenCounter + " Even numbers: ");
    for(int j =0; j < numb; j++){


        if(array[j] %2 == 0){


            System.out.print(array[j]);
            System.out.print(" ");

        }

    }


    System.out.println();
    System.out.println();




    for(int k =0; k < numb; k++){

        if(array[k] %2 == 1){
            oddCounter++;

        }

    }
    System.out.println("Dessa " + oddCounter +  " Odd numbers: ");
    for(int k =0; k < numb; k++){

        if(array[k] %2 == 1){

            System.out.print(array[k]);
            System.out.print(" ");

        }

    }

}