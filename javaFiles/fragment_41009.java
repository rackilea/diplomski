private final Pattern var = Pattern
        .compile("\\{\\s*([\\w\\[\\]\\(\\)\\.]+)\\s*\\}");
private final PropertyUtilsBean bean = new PropertyUtilsBean();
private final Object data;

public TrivialTemplate(Object data) {
    this.data = data;
}

public void process(BufferedReader reader, PrintWriter writer) {
    String line = null;
    try {
        while ((line = reader.readLine()) != null) {
            Matcher match = var.matcher(line);
            int offset = 0;
            while (match.find()) {
                writer.write(line.substring(offset, match.start()));
                String key = match.group(1);
                if (!isBlank(key)) {
                    Object val = bean.getNestedProperty(data, key
                            .toLowerCase());
                    writer.write(val != null ? val.toString() : "{null}");
                } else {
                    writer.write("{null}");
                }
                offset = match.end();
            }
            writer.write(line.substring(offset));
            writer.println();
        }
    } catch (Throwable t) {
        throw new RuntimeException("template error", t);
    }
}