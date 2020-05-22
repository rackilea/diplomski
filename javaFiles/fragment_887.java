int[] number = new int[10];
    int count=0;
    int num;
    Random r = new Random();
    while(count<number.length){
        num = r.nextInt(21);
        boolean repeat=false;
        do{
            for(int i=0; i<number.length; i++){
                if(num==number[i]){
                    repeat=true;
                    break;
                }
                else if(i==count){
                    number[count]=num;
                    count++;
                    repeat=true;
                    break;
                }
            }
        }while(!repeat);

    }

    for(int j=0;j<number.length;j++){
        System.out.print(number[j]+" ");
    }