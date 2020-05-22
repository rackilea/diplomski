for(int i=1; i<=32; i++) {
        if( (mask & number) != 0 )
            System.out.print(1);
        else
            System.out.print(0);


        if( (i % 4) == 0 )
            System.out.print(" ");

        mask = mask >> 1;
    }