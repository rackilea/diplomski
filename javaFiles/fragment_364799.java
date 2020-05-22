if (console != null) {
        String format = "%1$4s %2$10s %3$10s%n";

        console.printf(format, "Name", "Category", "Price");
        console.printf(format, "-----", "-----", "-----");
        console.printf(format, getName(), getCategory(), getPrice());
    }