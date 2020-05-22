class VehicleListComparator implements Comparator<List<Vehicle>> {
    private final Ordering<Class<? extends Vehicle>> vehicleClassOrdering;

    public VehicleListComparator(Ordering<Class<? extends Vehicle>> vehicleClassOrdering) {
        this.vehicleClassOrdering = vehicleClassOrdering;
    }

    @Override
    public int compare(List<Vehicle> vehiclesList1, List<Vehicle> vehiclesList2) {
        Class<? extends Vehicle> left = getVehicleClass(vehiclesList1);
        Class<? extends Vehicle> right = getVehicleClass(vehiclesList2);
        return vehicleClassOrdering.compare(left, right);
    }

    private Class<? extends Vehicle> getVehicleClass(List<Vehicle> vehicleList) {
        if (vehicleList.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return vehicleList.get(0).getClass();
        }
    }
}