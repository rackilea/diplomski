for (int i=0; i<num;i++){
        if (i==0 || i == num-1) {
            for (int j=0;j<num;j++){
                System.out.print("X");
            }
            System.out.println();
        }
        else {
            System.out.print("X");
            for (int j=1;j<num-1;j++){
                System.out.print(" ");
            }
            System.out.println("X");
        }
    }