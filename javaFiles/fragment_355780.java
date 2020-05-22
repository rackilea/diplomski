if (value instanceof Boolean) {
        if (Boolean.TRUE.equals(value)) {
            // do something for true
        }
        else {
            // do something for false
        }
    }
    else if (value != null) {
        // for any other non-null and not Boolean object call the super method
        super.setValue(value);
    }
    else {
           // do something for null
    }