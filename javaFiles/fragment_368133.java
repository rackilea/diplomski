for ( int i=0 ; i < this.getlength() ; i++) {
    for ( int j=0 ; j < this.getlength() ; j ++) {
        if (i==0 || j==0 || i==this.getLength()-1 || j==this.getLength()-1)
            System.out.print("$");
        else
            System.out.print(' ');
    }
    System.out.println();
}