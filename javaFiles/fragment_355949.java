public String readUTF(int offset) throws IOException {
    FileInputStream is = new FileInputStream(fileName);

    Reader fileReader = new InputStreamReader(is, "UTF-8");
    StringBuilder stringBuilder = new StringBuilder();

    fileReader.skip(offset);

    int charsRead;
    char buf[] = new char[256];

    //Read until there is no more characters to read.
    while ((charsRead = fileReader.read(buf)) > 0) {
        stringBuilder.append(buf, 0, charsRead);
    }

    fileReader.close();

    return stringBuilder.toString();
}