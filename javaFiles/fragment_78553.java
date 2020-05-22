Runtime r = Runtime.getRuntime()
Process p = r.exec("tail -f")
Scanner s = new Scanner(p.getInputStream())
while (s.hasNextLine()) {
    String line = s.nextLine()
    // Do whatever you want with the output.
}