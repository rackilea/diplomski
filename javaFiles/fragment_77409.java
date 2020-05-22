reader = new BufferedReader(new FileReader(file));
int i = 0;
while (++i < randomLineIndex)
    // Skip all lines before the one we want
    reader.readLine();
String randomLine = reader.readLine();