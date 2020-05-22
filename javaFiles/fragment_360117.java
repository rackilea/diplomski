String line;
while (scanner.hasNextLine() && !isBlank(line = scanner.nextLine())) {

     String[] accountData = line.split("/");
     String user = accountData[0];
     String password = accountData[1];
     System.out.println(user + ", " + password);
}