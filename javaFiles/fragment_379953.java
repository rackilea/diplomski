void setTemperature(int t){
  this.temperature = t;
}

Pizza build() {
   Pizza pizza = new Pizza(... usual constructor stuff);
   pizza.setTemperature(temperature);
   return pizza;
}