Proj1CarData newCar = new Proj1CarData(name, modelYear, listPrice, percentDiscount, discountAmount, netPrice);

int index = Collections.binarySearch(carList, newCar);
if (index < 0) {
    index = (index * -1) - 1;
}

carList.add(index, newCar);