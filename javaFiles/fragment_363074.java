private static final HashMap<String, String> mapping;
static
{
    mapping = new HashMap<>();
    mapping.put("0", "Zero");
    mapping.put("1", "One");
    mapping.put("2", "Two");
    mapping.put("3", "Three");
    mapping.put("4", "Four");
    mapping.put("5", "Five");
    mapping.put("6", "Six");
    mapping.put("7", "Seven");
    mapping.put("8", "Eight");
    mapping.put("9", "Nine");
}

private String numToWords(int number) {
    String[] num = String.valueOf(number).split("(?!^)");

    StringBuilder s = new StringBuilder();
    for (int idx = 0; idx < num.length; idx++) {
        s.append(mapping.get(num[idx]) + " ");
    }

    return s.toString();
}