public class PersonDatabase {

  private ArrayList<String[]> people = new ArrayList();
  // Reads the given input file and loads it into an ArrayList of string arrays.
  public PersonDatabase(String inputFile) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(inputFile));
    for (String line = null; null != (line=in.readLine()); ) {
        people.add(line.split(",")); // convert csv string to an array of strings.
    }
    in.close();
  }

  private static final int AGE_COLUMN_INDEX=2; // Identifies the 'age' column

  // performs a numeric comparison on the 'age' column values.
  int compareAge(String[] a1, String[]a2) {
    return Integer.compare(
        Integer.parseInt(a1[AGE_COLUMN_INDEX]),             
        Integer.parseInt(a2[AGE_COLUMN_INDEX]));
  }
  // Sorts the list of people by age and writes to the given output file.
  public void writeSorted(String outputFile) throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(outputFile));
    people.stream()
            .sorted(this::compareAge)                          // sort by age
            .forEach(a->{
                Arrays.stream(a).forEach(s->out.print(s+",")); // print as csv
                out.println();
            });
    out.close();
  }

  public static void main(String[] args) throws IOException {
    PersonDatabase pdb = new PersonDatabase("persondb.in");
    pdb.writeSorted("persondb.out");
  }
}