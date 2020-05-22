static final double DEFAULT_DATA = -1d;   // replace with your desired default value

while (inputStream.hasNextLine()) {
    String line = inputStream.nextLine();
    String[] data = line.split(" ");

    objectGenerator object = null;

    if (data.length == 1 && data[0].equals("")) {  // empty line
        object = new objectGenerator(DEFAULT_DATA, DEFAULT_DATA);
    }
    else if (data.length == 1) {                   // only one number
        object = new objectGenerator(Double.parseDouble(data[0]), DEFAULT_DATA);
    }
    else {                                           // two numbers
        object = new objectGenerator(Double.parseDouble(data[0]),
                                     Double.parseDouble(data[1]));
    }

    // you may want to check if (object == null) here to cover any weird edge cases
    objects.add(object);
}