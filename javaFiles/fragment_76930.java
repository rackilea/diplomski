public class ReplacingWriter extends StringWriter {

    protected Writer out;

    public ReplacingWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void close() throws IOException {
        String s = toString();
        for (int i = 0, len = rules.size(); i < len;) {
            String a = rules.get(i++);
            String b = rules.get(i++);
            s = s.replaceAll(a, b);
        }
        out.write(s);
        out.close();
    }

    private final ArrayList<String> rules = new ArrayList<String>();

    public void addRule(String regex, String replacement) {
        rules.ensureCapacity(rules.size() + 2);
        rules.add(regex);
        rules.add(replacement);
    }
}
...
Serializer ser = processor.newSerializer();
rwr = new ReplacingWriter(fos);
rwr.addRule("MYENTITY_([^:]*):", "&$1;");
ser.setOutputWriter(rwr);
...
Serializer ser = processor.newSerializer();
rwr = new ReplacingWriter(fos);
rwr.addRule("MYENTITY_([^:]*):", "&$1;");
ser.setOutputWriter(rwr);
...
out.writeAttribute("storeent_id", "MYENTITY_MAR_STOREENT_ID:");