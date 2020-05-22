String rawData = getContent("cats.json");
StringReader reader = new StringReader(rawData);

[...]
reader.mark(0); // reset
m.readValue(reader, type);
[...]