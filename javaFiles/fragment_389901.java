String[] arr = { "String1 String2 12 348 51 34 567", "StringAlone 12 348 51 34 567",
        "ManyString ManyString1 ManyString2 12 348 51 34 567" };
Pattern right = Pattern.compile("(\\d+ \\d+ \\d+ \\d+ \\d+)$");
for (String data : arr) {
    Matcher m = right.matcher(data);
    if (m.find()) {
        String token = m.group();
        String str = data.substring(0, data.indexOf(token) - 1);
        System.out.println(str);
        int[] numbers = Arrays.stream(token.split(" "))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(numbers));
    }
}