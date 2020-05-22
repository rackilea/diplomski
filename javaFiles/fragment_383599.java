String input = "Name                                     Age                   Working Experience          Position                     \n" +
               "John                                     23                    10                          Team Leader                          \n" +
               "Christian Elverdam                       27                    7                           Director                    \n" +
               "Niels Bye Nielsen                        59                    16                          Composer\n" +
               "Rajkumar Hirani                          40                    23                          Director               \n" +
               "Vidhu Vinod Chopra                      58                    21                          Screenplay\n";

List<String[]> rows = new ArrayList<>();
try (BufferedReader in = new BufferedReader(new StringReader(input))) {
    in.readLine(); // skip header line
    for (String line; (line = in.readLine()) != null; ) {
        rows.add(line.split(" {2,}"));
    }
}
for (String[] row : rows)
    System.out.println(Arrays.toString(row));