BufferedReader buffer = new BufferedReader(new FileReader("allcards.txt"));

VCardEngine engine = new VCardEngine();
StringBuilder builder = new StringBuilder();
List<VCard> vcards = new ArrayList<VCard>();

String line;
while ((line = buffer.readLine()) != null) {
    builder.append(line);

    if (line.contains("END:VCARD")) {
        VCard vcard = engine.parse(builder.toString());
        vcards.add(vcard);
        builder = new StringBuilder();
    }
}