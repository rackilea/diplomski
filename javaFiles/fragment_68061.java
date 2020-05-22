while(true){
    if(n<1 || n>20 || nReps<1 || nReps>10){
        System.out.println("values are not accepted, please insert again");
        n = in.nextInt();
        nReps = in.nextInt();
    }
    else{
        System.out.println(Math.pow(n, nReps));
        break;
    }
}