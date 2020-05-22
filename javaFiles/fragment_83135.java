String line = null;
while ((line = br.readLine()) != null) {
    if(!line.startsWith("\u0009")) {
        list.add(line);
    }
}