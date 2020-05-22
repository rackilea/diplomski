while (j < autos.length) {
        String type = autos[j++];
        if (vehicle.equalsIgnoreCase(type)) {
            Vehicle v = new Vehicle();
            v.setOwnerName(autos[j++]);
            allVehicles.add(v);
        } else if(car.equalsIgnoreCase(type)){
            Car c = new Car();
            c.setOwnerName(autos[j++]);
            allVehicles.add(c);
        }
    }