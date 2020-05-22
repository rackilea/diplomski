class ABC{
    final int a;

    public ABC(){
       if(Math.random() < .5){
          a = 2;
       }
       else{
          a = 12345;
       }

       byte b = a;
    }
}