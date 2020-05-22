while (j < autos.length) {
        if (vehicle.equalsIgnoreCase(autos[j])) {
            j++;
            Vehicle v = new Vehicle();
            v.setOwnerName(autos[j++]);
            allVehicles.add(v);
        } else if(car.equalsIgnoreCase(autos[j])){
            j++;
            Car c = new Car();
            c.setOwnerName(autos[j++]);
            allVehicles.add(c);
        }
    }