try {
    File file = new File("filename");
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line = "", oldtext = "";
    while ((line = reader.readLine()) != null) {
        oldtext += line + "\r\n";
    }
    reader.close();

    // replace a word in a file
    oldtext = oldtext.replaceAll("%LOGSOURCE% >eth1 rule: 7;", "");
    oldtext = oldtext.replaceAll("rule_uid: \\{C1336766-9489-4049-9817-50584D83A245\\};", "");

    FileWriter writer = new FileWriter("newfilename");

    // the entire file is contained within the String 'oldtext'
    // you only need one write operation to output it
    writer.write(oldtext);
    writer.close();
} catch (IOException ioe) {
    ioe.printStackTrace();
}