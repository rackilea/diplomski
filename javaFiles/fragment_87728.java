for(int i = 1; i <= 5; i++){
    for(int j = 1; j<=i; j++){
        System.out.print("*");
    }
    System.out.println();
    if(i == 4){
        for(int f = 0; f < 5; f++){
            System.out.print("*");
        }
    }
}

for(int i = 1; i <= 5; i++){
    for(int j = 4; j>=i; j--){
        System.out.print("*");
    }
    System.out.println();
}