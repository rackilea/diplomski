if (console != null) {
        String format = "%1$4s %2$10s %3$10s%n";
        String output;
        output = String.format(format, "Name", "Category", "Price");
        makeBlue(output);
        output = String.format(format, "-----", "-----", "-----");
        makeBlue(output);
        output = String.format(format, getName(), getCategory(), getPrice());
        makeBlue(output);
    }