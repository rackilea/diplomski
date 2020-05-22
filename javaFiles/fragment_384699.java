public void validateInput() {
    try {
        textfieldName.validate();
    } catch (InvalidInputExcpetion e) {
        // Error in the textfieldName
        // Eventually return if you need to validate only one field if an error is thrown
    }
    try {
        textfieldAge.validate();
    } catch (InvalidInputExcpetion e) {
        // Error in the textfieldAge
    }
}