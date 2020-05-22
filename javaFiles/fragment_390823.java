public void readJarFile(String result) {

    String name = result.substring(result.lastIndexOf("/") + 1);
    String entireWidget = "";
    String line;

    ArrayList<String> vars = new ArrayList<>();
    int begin, end;

    InputStream loc = this.getClass().getResourceAsStream(result);
    try (Scanner scan = new Scanner(loc)) {
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            entireWidget += line;

            while (line.contains("`%")) {

                begin = line.indexOf("`%");
                end = line.indexOf("%`") + 2;
                vars.add(line.substring(begin, end));
                //System.out.println("Variable added: " + line.substring(begin, end));
                line = line.substring(end);
            }

        }
    }
    System.out.println(name + ": " + entireWidget);
    Widget widget = new Widget(name, vars, entireWidget, result);
    widgetList.put(name, widget);

}