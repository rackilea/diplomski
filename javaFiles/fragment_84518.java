// Read all lines from source file
final Path source = Paths.get("/path/to/source.txt");
final List<String> lines = Files.readAllLines(source, StandardCharsets.UTF_8);

// Ask for necessary information

// Update relevant line
boolean found;
int idnumber;
String line;
Scanner scanner;
for (int index = 0; index < lines.size(); index++) {
    line = lines.get(index);
    scanner = new Scanner(line);
    idnumber = scanner.nextInt();
    if (idnumber != id_number) // not the good line
        continue;
    found = true;
    firstname = JOptionPane.showInputDialog("Enter First Name : ");
    lastname = JOptionPane.showInputDialog("Enter Last Name : ");
    lines.set(index, String.format("%d %s %s", idnumber, firstname, lastname);
    break; // no need to go further
}

if (!found) {
    JOptionPane.showMessageDialog(null, "Index not found" , "oops" ,
        JOptionPane.WARNING_MESSAGE);
    return;
}

//Create a temporary file to write the modified contents
final Path tmpfile = Files.createTempFile("temp", ".txt");
try (
    final BufferedWriter writer = Files.newBufferedWriter(tmpfile,
        StandardCharsets.UTF_8);
) {
    for (final String line: lines) {
        writer.write(line);
        writer.newLine();
    }
}

// Rename to original file
Files.move(tmpfile, source, StandardCopyOption.REPLACE_EXISTING);
JOptionPane.showMessageDialog(null, "Information Successfully updated" ,
    "edit information" , JOptionPane.INFORMATION_MESSAGE);