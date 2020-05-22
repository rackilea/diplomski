public static List<Seat> getSeats2(String filename) {

    final List<Seat> ret = new ArrayList<Seat>();
    BufferedReader br = null;

    try {
        br = new BufferedReader(new FileReader(filename));

        String line;
        while (line = br.readLine()) {
            final String[] parts = line.split("\\s"); // split on whitespaces
            // as above
        }
    }
    catch (Exception e) { /* handle errors */ }
    finally {
        if (br != null)
            try { br.close(); }
            catch (Exception e) {}
    }

    return res;
}