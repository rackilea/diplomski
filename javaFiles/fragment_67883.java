private Json json;
private StringWriter writer;

writer = new StringWriter();
json = new Json();
json.setWriter(writer);
write(json);