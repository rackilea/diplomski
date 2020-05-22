public boolean isEqual(Car car) {
    return this.Id == car.id &&
           this.reg == car.reg &&
           this.vin == car.vin &&
           this.make == car.make &&
           this.model == car.model;
}