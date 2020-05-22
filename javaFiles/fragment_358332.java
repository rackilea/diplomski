public static void readLines(File f, int[] nums, String[] vals) {
    int c = 0;
    try (Scanner s = new Scanner(f)) {
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.matches("^\\D+:\\d+")) {
                Scanner input = new Scanner(line).useDelimiter(":");
                vals[c] = input.next();
                nums[c] = input.nextInt();
                c++;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}