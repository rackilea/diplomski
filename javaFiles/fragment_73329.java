public double getTotalCost(){
  double total = 0;
  for(int i = 0; i < cart.size(); i++){
    total =  ( cart.get(i).getQuantity() * cart.get(i).getPrice() ) + total;
  }
  return total;
}