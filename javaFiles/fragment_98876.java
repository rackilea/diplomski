private static Map<String, String> CONVERSIONS = new HashMap<String, String>() {{
    put("\\U25", "Ü");
    put("\\o25", "ö");
    put("\\u25", "ü");
}};

private static String convert(String str) {
    for (Map.Entry<String, String> conversion : CONVERSIONS.entrySet()) {
        str = str.replace(conversion.getKey(), conversion.getValue());
    }
    return str;
}