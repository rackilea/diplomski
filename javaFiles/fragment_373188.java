@Override
protected Object clone() {
    Garage other = new Garage ();
    for (Vehicle v : this.array) {
        other.addVehicle((Vehicle)v.clone());
    }
    return other;
}