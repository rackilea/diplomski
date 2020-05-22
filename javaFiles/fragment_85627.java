success = jObject.getInt(TAG_SUCCESS);
 vehicles = jObject.getJSONArray(Vehicle.TAG_VEHICLES);

        if(success == 1) {
            // loop through all the vehicles
            for(int i = 0; i < vehicles.length(); i++) {
                JSONObject obj = vehicles.getJSONObject(i);

                // Get each element based on it's tag
                String year = obj.getString(Vehicle.TAG_YEAR);
                String model = obj.getString(Vehicle.TAG_MODEL);
                String brand = obj.getString(Vehicle.TAG_BRAND);
                String color = obj.getString(Vehicle.TAG_COLOR);
                String license_plate = obj.getString(Vehicle.TAG_LICENSE);
                String main_driver = obj.getString(Vehicle.TAG_DRIVER);
                String policeNumber = obj.getString(Vehicle.TAG_POLICENUMBER);
                String driversLicense = obj.getString(Vehicle.TAG_DRIVER_LICENSE);
                String licenseState = obj.getString(Vehicle.TAG_LICENSE_STATE);
                String driverBirthday = obj.getString(Vehicle.TAG_BIRTHDAY_MONTH) + "/" +
                        obj.getString(Vehicle.TAG_BIRTHDAY_DAY) + "/" +
                        obj.get(Vehicle.TAG_BIRTHDAY_YEAR);
                String driverGender = obj.getString(Vehicle.TAG_DRIVER_GENDER);

                ListRowGroup group = new ListRowGroup(brand + " " + year + " " + model, brand);
                group.children.add(brand + " " + year + " " + model);
                group.children.add(policeNumber);
                group.children.add(model);
                group.children.add(color);
                group.children.add(license_plate);
                group.children.add(main_driver);
                group.children.add(driversLicense + "   -   " + licenseState);
                group.children.add(driverBirthday + "   -   " + driverGender);

                vehiclesGroup.append(i, group);
            }