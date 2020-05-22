String line;
// reader is BufferedReader
while (((line = reader.readLine()) != null)) {
    if (line.startsWith("#")) {
        continue;
    } else if (line.startsWith("U")) {
        Variant variant = new Variant(line);
        variants.add(variant); // list of Variant objects
    }
}