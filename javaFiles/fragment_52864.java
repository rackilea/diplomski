Car lowestPrice = cars.get(0);
for(Car car : cars) {
   if(car.price<lowestPrice.price) {
       lowestPrice = car;
   }
}