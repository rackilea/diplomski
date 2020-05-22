BufferedReader br = new BufferedReader(new FileReader(paths));

String line1 = null, line2 = null;
line1 = br.readLine();
if (line1 != null) {
    line2 = br.readLine();
}