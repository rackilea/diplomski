String strpath = "/var/new.log", ch;
FileReader fr = null;
try {
    fr = new FileReader(strpath);
    BufferedReader br = new BufferedReader(fr);
    while ((ch = br.readLine()) != null)
        out.println(ch);
} catch (IOException e) {
    out.print(e.getMessage());
} finally {
    if (fr != null)
        fr.close();
}