public Boolean ValidateInputField(Contents unmarshalledValues) {
    // Extracting unmarshalled values from xml
    String A = unmarshalledValues.getA();
    String B = unmarshalledValues.getB();
    String C = unmarshalledValues.getC();
    String D = unmarshalledValues.getD();
    return checkNull(A, B, C, D);
}

private static boolean checkNull(String... strings) {
    for (String string : strings) {
        if (string == null || string.isEmpty()) {
            return false;
        }
    }
    return true;
}