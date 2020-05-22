public double getAverageValue(){
  double averageValue = 0;
  double sum = 0;

  if(cartLineList.size() > 0){
    for ( int i=0; i < cartLineList.size() ; i++) {
      // assuming the product class has a price
      sum += cartLineList.get(i).getProduct().getPrice();
    }
    averageValue = (sum / (double)cartLineList.size())
  }

  return averageValue;
}