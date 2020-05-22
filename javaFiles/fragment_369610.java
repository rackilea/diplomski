public List<Seat> getSeats(String filename) throws IOException {
    final String[] lines = ReadWholeFile(filename).split("\n");

    final List<Seat> ret = new ArrayList<Seat>();

    for (int i=0; i<lines.length; i++) 
        try {
            final String[] parts = lines[i].split("\\s"); // split on whitespaces
            final int num = Integer.parseInt(parts[0]);

            ret.add(new Seat(num, parts[1], isTrue(parts[2]), isTrue(parts[3]), isTrue(parts[4]), isTrue(parts[5]), isTrue(parts[6]));
        }
        catch (Exception e) { /* whatever */ }

    return ret;
}