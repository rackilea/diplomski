int index = 0;
String[] ids = scanner.split("\n");
while ((line = br.readLine()) != null) {
    String[] actionID = line.split("\\\",\"");

    String custnumber = actionID[3];
    String fullname = actionID[18];
    String add1 = actionID[19];

    if (ids.length > index) {
         lbwp.write("\"" + custnumber +  "\",\"" + fullname+ "\"," + "\"" + ids[index] + "\"," + "\n");
    } else {
        lbwp.write("\"" + custnumber +  "\",\"" + fullname+ "\"\n");
    }
    index++;
}