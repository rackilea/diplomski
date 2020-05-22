public Result checkListing() {

    try {

        // open the users.txt file
        BufferedReader br = new BufferedReader(new FileReader("users.txt"));

        String line = null;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(" ");
            // only interested for duplicate usernames
            if (username.equals(values[0])) {
                return new Result(true);
            }
        }
        br.close();
        return new Result(false);
    } catch (IOException e) {
        e.printStackTrace();
        return new Result(false, true, e);
    }
}