int a=20;
main(){
  sysout(a);

  if(true){
    int a = 30;  // now this will shadow the class variable a
    sysout(a);
  }
  sysout(a);
}