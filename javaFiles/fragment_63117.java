Properties prop = new Properties();
prop.put("version", "1.0.0.test");

ByteArrayOutputStream os = new ByteArrayOutputStream();
props.store(os, "comments");

InputStream s = new ByteArrayInputStream(os.toByteArray());

String version = getVersion(s);