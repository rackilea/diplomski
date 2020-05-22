XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()) {
        @Override
        public String escapeElementEntities(String str) {
            return str;
        }
    };
Writer writer = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
outputter.output(doc, writer);
writer.close();