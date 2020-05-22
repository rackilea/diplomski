ArrayList<String> appList = new ArrayList<String>();
Writer out = new StringWriter();
interpreter.setOut(out);
interpreter.exec("print listApplications()");   

StringBuffer results = new StringBuffer();
results.append(out.toString());

Scanner scanner = new Scanner(results.toString());
while(scanner.hasNextLine()){
    String line = scanner.nextLine();
    line = line.trim();
    if(line.equals("None"))
        continue;
    appList.add(line);
}