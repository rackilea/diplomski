public static void main(String[] args) {       

    System.out.println("Thank you for your call,\nPlease take some time to answer a few questions");
    Survey s = new Survey();
    s.Info();        
    s.collectData();
    s.getTotals();
    s.printTotals();

}//end