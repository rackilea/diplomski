double total = 0.0;
for (int j = 0; j < quantity.length; j++){

  total += quantity[j] * price[j];
}

if(total != 0){
   System.out.println("Total: " + total);
}