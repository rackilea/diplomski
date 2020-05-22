Proj1CarData newCar = new Proj1CarData(name, modelYear, listPrice, percentDiscount, discountAmount, netPrice);

int index = Collections.binarySearch(carList, newCar, 
    new Comparator<Proj1CarData>() {
        public int compare(Proj1CarData car1, Proj1CarData car2) {
            return car1.getName().compareToIgnoreCase(car2.getName());
        }
    });

if (index < 0) {
    index = (index * -1) - 1;
}

carList.add(index, newCar);