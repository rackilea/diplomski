for(int i=0;i<fiblist.length;i++){
   System.out.print(fiblist[i]+",");
}
System.out.println();

for (int i=0;i<5;i++){
    temp=fiblist[i];
    fiblist[i]=fiblist[fiblist.length-i-1];
    //the first ellement= the last
    //the second=second from last...
    fiblist[fiblist.length-1-i]=temp;
}

for(int i=0;i<fiblist.length;i++){
    System.out.print(fiblist[i]+",");
}