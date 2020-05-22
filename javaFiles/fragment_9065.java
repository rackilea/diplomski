while(i<s.length()){
    c=s.charAt(i);
    LL.addfromTail(new LinkData(c));
    //LL.BinarytoInt(new LinkData(c)); //remove this
    i++;    
}//end while

LL.BinarytoInt(); //Do this after the list is populated

LL.PrintList();
System.out.println();