index=patternLength+1; n=1;int nSetter=1;
    //Loop C
    System.out.println("Pattern C:");
    while (index!=1) {
        index--;
        printSpaces((index*2)-2);
        while(n!=0) {

            System.out.print(n + " ");
            n--;
        }
        System.out.print("\n");
        nSetter++;
        n = nSetter;
    }