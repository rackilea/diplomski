while(leads[0]||leads[1]||leads[2]||leads[3]||leads[4]
            ||leads[5]||leads[6]||leads[7]){
    System.out.println("leads[0]: " + leads[0]);
    System.out.println("leads[1]: " + leads[1]);
    // etc.

    int i = 2;
    if(leads[0])  // 7 other directions are searched given that their marker is true.
        this.searchN(x,y,i);    
}