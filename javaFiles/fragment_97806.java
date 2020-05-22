Random ran = new Random();
int position = 0; 

while(Math.abs (position) != 3){

    int r = ran.nextInt(2);

    if(r == 0){
       position += 1;
    }else{
        position -= 1 ; 
    }
    System.out.println("position = " + position);
}
System.out.println("max position = " + position);