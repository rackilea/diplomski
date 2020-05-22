for (Auto auto : autos) {
  AutoCar ac = new AutoCar();
  ac.setType(auto.getType());
  ac.setCars(carService.getCarsByType(auto.getType())); //<-- your service/method call here
  acList.add(ac);
}