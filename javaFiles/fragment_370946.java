try {
    Pattern p = Pattern.compile("\\d+\\.\\d+");
    if(!p.matcher(NumOfUnitsField.getText()).matches()){
        throw new NumberFormatException("Not a double");
    }
    double itemVolume = Double.parseDouble(NumOfUnitsField.getText());
} catch (NumberFormatException exception) {
    SetErrorField("Input must be the appropriate type (real number for volume, integer for units)");
}