public static Location parseLocation(String input) {
    // Get the input and split it into an array of "key: value" strings.
    String[] splitInput = input.split(", ");

    // Create an array to hold the actual key-values.
    String[][] keyValues = new String[splitInput.length][2];

    // Split each "key: value" string into its consisting parts.
    for (int i = 0; i < splitInput.length; i++) {
        keyValues[i] = splitInput[i].split(": ");
    }

    // Create a Location object to populate.
    Location location = new Location();

    // Find the keys & values from the input that you're looking for.
    for (String[] keyValue : keyValues) {

        // Switch on the key.
        switch (keyValue[0]) {
            case "id":
                location.setId(Integer.valueOf(keyValue[1]));
                break;

            case "street1":
                location.setStreet1(keyValue[1]);
                break;

            case "street2":
                location.setStreet2(keyValue[1]);
                break;

            case "street3":
                location.setStreet3(keyValue[1]);
                break;

            case "city":
                location.setCity(keyValue[1]);
                break;
        }
    }
    return location;
}