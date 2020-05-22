void setup(){
  if(args != null){
     for(int i = 0; i < args.length; i++) 
        text(args[i],0,10+i*10);
  }
}