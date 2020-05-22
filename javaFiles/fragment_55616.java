for (CarBrand car: CarModel.getCarBrandDetails()) {
        carDetails.put(car.getCarBrand(), new Color(
            rgb[i][0], rgb[i][1], rgb[i][2]));
        i++;
    }
    if (carTable != null) {
        for (Component c : carTable.getComponents()) {
            if(carDetails.containsKey(c.getName()) {
                c.setForeground(carDetails.get(c.getName())));
            }
        }
    }