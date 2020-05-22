public static void drawCross(int num){
    for(int i = 0; i < num; i++) {
        for(int j = 0; j < num; j++){
            if((i == num / 2) || (j == num / 2)){
                if((i == (num-1) / 2) == (j == (num-1) / 2)){
                    System.out.print(" ");
                } else {
                    System.out.print("X");
                }
            } else { 
                System.out.print(" ");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}