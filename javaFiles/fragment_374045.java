String[] strings = {
        "SAMPLE:1-2-8-SAM#1",
        "SAMPLE:1-1-8-SAM#1",
        "SAMPLE:1-1-8-SAM#13",
        "DEMO:1-1-4-SAM#13",
        "DEMO:1-1-4-SAM#26",
        "DEMO:1-1-4-SAM#8"
};

final List<String> sorted = Arrays.stream(strings)
        .map(str -> str.split("((?<=[:\\-#])|(?=[:\\-#]))"))
        .sorted(Comparator
                .<String[], String>comparing((arr) -> arr[0])      // String compare
                .thenComparing(arr -> Integer.valueOf(arr[2]))     // Integer compare
                .thenComparing(arr -> Integer.valueOf(arr[4]))     // Integer compare
                .thenComparing(arr -> Integer.valueOf(arr[6]))     // Integer compare
                .thenComparing(arr -> Integer.valueOf(arr[10])))   // Integer compare
        .map(l -> Arrays.stream(l).collect(Collectors.joining()))  // Map it back to a String
        .collect(Collectors.toList());                             // Collect it to a List for further processing