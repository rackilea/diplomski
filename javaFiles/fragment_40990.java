public static void main(String[] args) {
        String s = "This is a sample code line 1.\n" +
                "This is a sample code line 2.\n" +
                "\n" +
                "Warm Regards,\n" +
                "SomeUser.";

        int truncateIndex = s.length();

        for (int i = 0; i < 3; i++) {
            System.out.println(truncateIndex);
            truncateIndex = s.lastIndexOf('\n', truncateIndex - 1);
        }

        System.out.println(s.substring(0, truncateIndex));
        System.out.println("--");
    }