StringBuilder b = new StringBuilder();
int read = reader.read();
while(read != -1) {
    b.append((char) read);
    read = reader.read();
}