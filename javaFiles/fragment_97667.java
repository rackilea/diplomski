int c = in.read();
while (c != -1) {
    System.out.println(c);
    out.write(c);
    c = in.read();
}