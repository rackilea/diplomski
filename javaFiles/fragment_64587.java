public InputValues(int[] myarraypass) { 

    this.myarrayvar = new int[myarraypass.length];    

    System.arraycopy(myarraypass, 0, this.myarrayvar, 0, myarraypass.length );

}