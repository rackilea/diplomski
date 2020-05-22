//Declarations
    int A=0,B=0,C=0,D=0,F=0, score,I, students;
    I=1;

    System.out.println("How many students are in your class: ");
    students = input.nextInt();
    while (I<=students) {
        System.out.println("enter a score:");
        score=input.nextInt();


        if(score >= 90 && score <= 100)
            A++;
        else if(score>=80 && score<=89)
            B++;
        else if(score>=70 && score<=79)
            C++;
        else if(score>=60 && score<=69)
            D++;
        else if(score>=0 && score<=59)
            F++;


        I++;  //or students--

    }

    System.out.println("Total number of A's:"+ A);
    System.out.println("Total number of B's:"+ B);
    System.out.println("Total number of C's:"+ C);
    System.out.println("Total number of D's:"+ D);
    System.out.println("Total number of F's:"+ F);