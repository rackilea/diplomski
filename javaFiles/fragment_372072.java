Car carWithWantedColor = null;
for (Car car : carList){
    if (wantedColor.equals(car.getColor())){
        carWithWantedColor =  car;
        break;
    }
}
return carWithWantedColor;