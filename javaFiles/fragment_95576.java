ArrayList<String> abc = new ArrayList<>(Arrays.asList(
        "64.3", "25.1", "44.3", "34.2", "6.4", "48.5", "35.5",
        "59.5", "54.6", "26.6", "11.2", "50.3", "25.1" ));
System.out.println("abc = " + abc);

// Loop (all Java versions)
int[] cab1 = new int[abc.size()];
for (int i = 0; i < cab1.length; i++)
    cab1[i] = (int)Double.parseDouble(abc.get(i));
System.out.println("cab1 = " + Arrays.toString(cab1));

// Java 8 stream with lambda expression
int[] cab2 = abc.stream()
                .mapToInt(v -> (int)Double.parseDouble(v))
                .toArray();
System.out.println("cab2 = " + Arrays.toString(cab2));

// Java 8 stream with method references
int[] cab3 = abc.stream()
                .map(Double::valueOf)
                .mapToInt(Double::intValue)
                .toArray();
System.out.println("cab3 = " + Arrays.toString(cab3));