public static boolean inRange(String range, int value) {
    return Arrays.stream(range.split(" , "))
        .anyMatch(t -> {
            // Split the two integers denoting the range. The length of the
            // array is 1 if the range is an exact value (500 in your case),
            // otherwise, its length is 2
            String[] parts = t.split("(?<!^)-", 2);
            int minVal = Integer.valueOf(parts[0]);
            int maxVal = (parts.length == 2 ? Integer.valueOf(parts[1]) : minVal);
            return (minVal <= value && value <= maxVal);
        });
    }
}