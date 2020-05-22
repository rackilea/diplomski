if (console != null) {
        String format = "%1$4s %2$10s %3$10s%n";
        makeBlue(String.format(format, "Name", "Category", "Price"));
        makeBlue(String.format(format, "-----", "-----", "-----"));
        makeBlue(String.format(format, getName(), getCategory(), getPrice()));
    }