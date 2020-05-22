try {
    //skips n integers
    for (int i = 0 ; i != n ; i++) {
        d.readInt();
    }
    System.out.println("Requested Integer is "+d.readInt());
    d.close();
}
catch(Exception e) {}