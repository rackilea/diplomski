byte[] data = pack1.getData();
InputStreamReader input = new InputStreamReader(
    new ByteArrayInputStream(data), Charset.forName("UTF-8"));

StringBuilder str = new StringBuilder();
for (int value; (value = input.read()) != -1; )
    str.append((char) value);