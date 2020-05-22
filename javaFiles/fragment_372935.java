StringBuilder b = new StringBuilder();
int n = 0;
while (file.hasNext()) {
    s = file.nextLine();
    n++;
    System.out.println(n + ". " + s);
    b.append(n).append(". ").append(s).append(System.getProperty("line.separator"));
}// end while
PrintWriter printer = new PrintWriter(output);
printer.println(b.toString());