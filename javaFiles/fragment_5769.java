public static iPhone read(Scanner sc) { // Better yet just make it received a String
    final String line = sc.nextLine();
    final String [] result = line.split("(,)\\s*");

    // count if the number of inputs are correct
    if (result.length == 8) {
        boolean touchtech = false;
        final String model = result[0];
        final double screensize = Double.parseDouble(result[1]);
        final String processor = result[2];
        final String modem = result[3];
        final String color = result[4];
        final String memory = result[5];
        final String touchtechtest = result[6];
        if(touchtechtest.equals("TRUE")) {
            touchtech = true;
        }
        final int price = Integer.parseInt(result[7]);
        return new iPhone(model, screensize, processor, modem, color, memory, touchtech, price);
    }
    return new iPhone();// empty iphone
}