String line = "";
while (in.hasNext()) {
    if (!(line = in.next()).isEmpty()) {
        type.add(line.toUpperCase());
    }
}