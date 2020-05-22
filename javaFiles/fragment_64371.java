while (line != null) {
    String[] separations = line.split(", "); // this should be inside the loop
    if (separations.length > 1) {
        this.times.add(separations[0]);

        Double number = Double.parseDouble(separations[1]);
        allNumbers.add(number);
    }
    line = buffer.readLine();
}