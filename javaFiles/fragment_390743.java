public static void main(String[] args) {
        String input = "reserved_parking";
        if (input.trim().toUpperCase().contains("Park".toUpperCase()))
            dummies = dummies + "   1";
        else
            dummies = dummies + "   0";

        System.out.println(dummies);
    }