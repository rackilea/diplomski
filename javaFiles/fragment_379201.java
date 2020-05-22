IntegerProperty intProperty = new SimpleIntegerProperty();
    intProperty.addListener((observable, oldValue, newValue) -> {

        if (!oldValue.equals(newValue) ) {
            System.out.printf("Value has been changed from %d to %d!%n", oldValue.intValue(), newValue.intValue());
        }
    });

    intProperty.setValue(1); // Output: Value has been changed from 0 to 1!
    intProperty.setValue(2); // Output: Value has been changed from 1 to 2!
    intProperty.setValue(2); // No output

    System.out.println(intProperty.intValue()); // Output: 2