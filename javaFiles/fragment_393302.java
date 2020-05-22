DateTime current = start;
while(true){
    System.out.println(current);
    current=current.plusMinutes(30);
    if(current.isAfter(stop))break;
}