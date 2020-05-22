final Parser parser = new Parser();
final StringWriter writer = new StringWriter();

parser.setContentHandler(new XMLWriter(writer));
parser.parse(new InputSource(
        new URL("http://oregonstate.edu/instruct/phl302/texts/hobbes/leviathan-c.html")
                .openConnection().getInputStream()));
System.out.println(writer.toString());