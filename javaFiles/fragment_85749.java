while (sc.hasNextLine()) {
    String line = sc.nextLine();
    if (line.isEmpty()) {
        break;
    }
    c.add(new Customer(Double.parseDouble(line)));
}