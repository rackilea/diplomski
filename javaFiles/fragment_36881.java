Statement stm = con.createStatement();
BufferedReader reader = new BufferedReader(new FileReader(new File(...)));
while (true) {
    String line = reader.readLine();
    if (line == null) {
        break;
    }
    // this is the trick -- you need to pass different SQL to different methods
    if (line.startsWith("SELECT")) {
        stm.executeQuery(line);
    } else if (line.startsWith("UPDATE") || line.startsWith("INSERT")
        || line.startsWith("DELETE")) {
        stm.executeUpdate(line);
    } else {
        stm.execute(line);
    }
}
stm.close();