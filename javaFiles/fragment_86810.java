static CSVReader read = null;
static CSVWriter writer = null;
static String csvfile;
static List<String[]> arg = null;
static Scanner in = new Scanner(System.in);

public static List<String[]> readFile(CSVReader read, List<String[]> arg) throws IOException {
    arg = read.readAll();

    for (String[] lineTokens : arg) {
        for (String token : lineTokens) {
            System.out.print(token + ",");
        }
        System.out.println("");
    }
    return arg;
}

public static void write_to_csv(String command_input, String command_output, CSVWriter writer, String csvfile, List<String[]> arg) throws IOException {
    String[] count = (command_input + "," + command_output).split(",");
    String rename = (getFilename(csvfile) + "_part.csv");
    int i = 0;
    String[] tail;
    writer = new CSVWriter(new FileWriter(rename));
    for (String[] head : arg) {
        if (head[0].equals(command_input)) {

            i = 0;
            tail = new String[head.length + 1];
            for (String h : head) {
                tail[i] = h;
                System.out.println(h);
                i++;
            }
            tail[tail.length - 1] = command_output;
            writer.writeNext(tail);
        } else {
            i--;
            writer.writeNext(head);
        }
    }
    if(i < 0){
        writer.writeNext(count);
    }
    writer.close();
    File original = new File(rename);
    File gre = new File(csvfile);
    boolean fr = original.renameTo(gre);
    System.out.println(fr);
}

static {
    try {
        System.out.println("Enter the file name");
        csvfile = in.nextLine();
        File file_exists = new File(csvfile);
        if (file_exists.exists()) {
            read = new CSVReader(new FileReader(csvfile));
        } else {
            file_exists.createNewFile();
            read = new CSVReader(new FileReader(csvfile));

        }
        arg = readFile(read, arg);
        read.close();
        if (file_exists.delete()) {
            System.out.println(file_exists.getName() + " is deleted.");
        } else {
            System.out.println("Operation Failed");
        }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DifferentApproach.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(DifferentApproach.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public static String getFilename(String csvfile) {
    String last[] = csvfile.split("\\.");//csvfile.split(".*(?=\\.)");
    return last[last.length - 2];
}

public static void main(String... args) {
    try {
        write_to_csv("mno", "Hi I am N Deepak Prasath", writer, csvfile, arg);
    } catch (IOException ex) {
        Logger.getLogger(DifferentApproach.class.getName()).log(Level.SEVERE, null, ex);
    }

}