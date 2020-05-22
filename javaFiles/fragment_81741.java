String Seq = jTextArea1.getText();

    int aCounter = 0;
    int tCounter = 0;
    int cCounter = 0;
    for( int i=0; i<Seq.length(); i++ ) {
        if(Seq.charAt(i) == 'A' ) {
           aCounter++;}
        elseif(Seq.charAt(i) == 'T' ) {
           tCounter++;}
        elseif(Seq.charAt(i) == 'C' ) {
           cCounter++;}
    }
    System.out.println(aCounter);
    System.out.println(tCounter);
    System.out.println(cCounter);