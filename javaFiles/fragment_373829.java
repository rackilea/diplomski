Scanner scanner = new Scanner(string);        
    String validationResult = scanner.findInLine("[^0-9()+\\-*\\/%]+");
    if (validationResult != null) {
        // Invalid character found.
        throw new InvalidCharacterException("Invalid character: " + validationResult);
    }