if (temp < BOTTOM_TEMP) {
  //System.out.println("This works! The temperature is " + temp);
  if (o instanceof Heating){
    ((Heating)o).turnOn(); 
  }
}