public static void addRow() {   
    int rowNum = i; //solution: a local variable to keep current i value  
     .....
    decreaseQuantBut.setOnAction(e -> Controller.shoppingCart.getOrder(rowNum).decreaseQuantity());
    increaseQuantBut.setOnAction(e -> Controller.shoppingCart.getOrder(rowNum).increaseQuantity());
    .....
}