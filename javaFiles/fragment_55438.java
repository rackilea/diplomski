Scanner s = new Scanner(args[3]);
while (s.hasNextInt()) {
    int amount = s.nextInt();
    String unit = s.next();
    if ("m".equals(unit)) {
        // handle minutes
    } else if ("h".equals(unit)) {
        // handle hours
    } else if ("d".equals(unit)) {
        // handle days
    } else {
        // handle unexpected input
    }
}