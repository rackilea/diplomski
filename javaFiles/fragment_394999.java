MyCar car = null;
try {
   car = CarManager.findCarById("U983");
} catch (NullPointerException e) {
   car = null;
}