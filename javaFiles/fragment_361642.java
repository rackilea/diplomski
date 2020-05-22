public static void main(String[] args) {
    String listtable = "listtable.dat";
    List<ListTableClass> ltc = new ArrayList<>();
    File f = new File(System.getProperty("user.home"), listtable);
    try (Scanner s = new Scanner(f)) {
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (line.trim().isEmpty()) {
                continue;
            }
            System.out.println(line);
            String[] to = line.split("|");
            Integer id = Integer.parseInt(to[0].trim());
            String fname = to[1].trim();
            String lname = to[2].trim();
            String address = to[3].trim();
            Integer age = Integer.parseInt(to[4].trim());
            ltc.add(new ListTableClass(id, fname, lname, address, age));
        }
    } catch (IOException e) {
        System.out.println("Caught Exception: " + e.getMessage());
        e.printStackTrace();
    }
    for (ListTableClass t : ltc) {
        System.out.println(t);
    }
}