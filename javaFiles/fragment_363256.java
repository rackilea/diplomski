while (!inputString.matches("[0-9]{5}")) {
    // ask again and again
    if (!isInteger(inputString)) {
        // invalid input
    } else {
        if (inputString.length() < 5) {
            // too low
        } else if (inputString.length() > 5) {
            // too high
        }
    }     
}