public void recTest(int i){
i--;
if(i > 0){
recTest(i);
}
System.out.print(i);
}

recTest(5);