public static void main(String[] args) {
        String input = "park";
        if (input.trim().toUpperCase().contains("Park".toUpperCase()))
            dummies = dummies + "   1";
        else
            dummies = dummies + "   0";

        System.out.println(dummies);
    }