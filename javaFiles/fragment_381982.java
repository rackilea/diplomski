int i = 5;
public void recTest(){
i--;
if(i > 0){
recTest();
}
System.out.print(i);
}