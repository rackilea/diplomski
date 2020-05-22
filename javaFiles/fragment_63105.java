public static void main(String[] args) {
    int sizeA=0, sizeB=0;int resultSize=0;
    String repeat;

    do{        
        System.out.println("ENTER 2 SETS OF NUMBERS.\n");
        System.out.println("HOW MANY NUMBERS IN YOUR FIRST SET?");
        sizeA=kbd.nextInt();

        int [] setA = new int[sizeA ]; //Initializing Array of size that user inputs.

        for(int i=0; i<sizeA; i++){

            if (sizeA>MAXSIZE){
                System.out.println("\nERROR: SET SIZE LIMIT EXCEEDED."
                        + "ENTER A DIFFERENT AMOUNT. \n");
                sizeA = kbd.nextInt();
            }

        }
        System.out.println("\nENTER THE FIRST SET OF NUMBERS");

        getData(setA, sizeA);
        sort(setA,sizeA);


        System.out.println("\nHOW MANY NUMBERS IN YOUR SECOND SET?");
        sizeB=kbd.nextInt();

        int [] setB = new int[sizeB]; //Initializing Array of size that user inputs.

        for(int i=0; i<sizeB; i++){

            if (sizeB>MAXSIZE){
                System.out.println("\nERROR: SET SIZE LIMIT EXCEEDED.  \n"
                        + "ENTER A DIFFERENT AMOUNT.\n ");
                sizeB = kbd.nextInt();
            }

        }
        System.out.println("\nENTER THE SECOND SET OF NUMBERS");

        getData(setB, sizeB);
        sort(setB, sizeB);

        /* Initializing the result array with Largest among sizeA and sizeB*/
        resultSize = sizeA;
        if(sizeB > sizeA)
        {
             resultSize = sizeB;
        }
        int [] resultSet = new int[resultSize];

        System.out.println("\nINTERSECTION:");
        resultSize=intersection(setA,sizeA,setB,sizeB, resultSet);
        for(int i=0; i<resultSize; i++){
            System.out.print(resultSet[i] + " ");
        }

        System.out.println("\n\nDIFFERENCE OF A-B:");
        resultSize=difference(setA,sizeA,setB,sizeB, resultSet);
        for(int i=0; i<resultSize; i++){
            System.out.print(resultSet[i]+" ");
        }
        System.out.println("\n\nDIFFERENCE OF B-A:");
        resultSize=difference(setB,sizeB,setA,sizeA, resultSet);
        for(int i=0; i<resultSize; i++){
            System.out.print(resultSet[i]+" ");
        }
        System.out.println("\n\nDO YOU WANT TO CONTINUE?");

        repeat= kbd.next().toLowerCase();

    } while(repeat.equals("y"));