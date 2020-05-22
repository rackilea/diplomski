private static void validate(Supplier<String> method, String name, String decimalRegEx, Errors errors) {
    String val = method.get();
    if (val==null || val.length()==0 || !val.matches(decimalRegEx)) {
        errors.rejectValue(name, "supplier." + name + ".invalid", "Invalid format for dollar amount");
    }
}