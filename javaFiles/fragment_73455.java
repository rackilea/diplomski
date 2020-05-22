while (fileReader.hasNext()) {
    String line = fileReader.nextLine();
    String[] splitText = line.split("-");
    if (splitText.length < 5) {
        System.out.println("One or more columns is entirely missing.");
        continue;     // skip this line
    }
    if (splitText[0].length == 0) {
        System.out.println("Title is missing")
    }
    if (splitText[1].length == 0) {
        System.out.println("Author is missing")
    }
    boolean isValidPrice = true;
    try {
        Double.parseDouble(splitText[2]);
    }
    catch (Exception e) {
        isValidPrice = false;
    }
    if (!isValidPrice) {
        System.out.println("Found an invalid price " + splitText[2] + " but expected a decimal.");
    }
    if (splitText[4].length != 11) {
        System.out.println("Found an invalid ISBN.");
    }