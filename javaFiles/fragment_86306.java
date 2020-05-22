public static COLOR getEnumFromString(final String value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        for (COLOR v : values()) {
            if (value.equalsIgnoreCase(v.getValue())) {
                return v;
            }
        }

        throw new IllegalArgumentException();
    }