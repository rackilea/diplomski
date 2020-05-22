InputStream inpStream = getClass().getResourceAsStream("/resources/myFile.txt");
try (BufferedReader reader = new BufferedReader(new InputStreamReader(inpStream, "UTF-8"))) {

    num = Integer.toString(a);

    String line;
    while ((line = reader.readLine()) != null) {

        if (line.equals(num)) {
            who = reader.readLine();
            what = reader.readLine();
            sat = reader.readLine();
            pow = reader.readLine();
            satNo = reader.readLine();
            cash = reader.readLine();
            break;
        }
    }

} catch (IOException e) {
}