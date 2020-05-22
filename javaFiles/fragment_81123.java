public static void main(String[] args){
int i=11;
int counter=0;
    while(counter<10){

        for(int j=1;j<=10;j++){
            if((i%j)!=0) {
                counter=0;
                break;
            }
            else counter++;
        }
        if(counter!=10)    //this change
        {
          i++;
        }
    }

    System.out.println("The number is: "+i);
}