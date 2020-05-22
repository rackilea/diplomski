public void cartInventory(){
    for(int i=0; i<cart.length; i++){
        if(cart[i] instanceof isPriceChecking){
            IsPriceChecking tmp = (IsPriceChecking)cart[i];
            tmp.checkPrice();
        }
        System.out.println();
    }
}