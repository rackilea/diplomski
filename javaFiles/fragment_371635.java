XmlMapper mapper = new XmlMapper();
XmlRequest request = (XmlRequest) mapper.readValue(App.class.getResourceAsStream("/NewFile.xml"), XmlRequest.class);

StringWriter sw = new StringWriter();

JsonGenerator jsongen = new JsonFactory().createJsonGenerator(System.out);

jsongen.writeStartObject();
jsongen.writeFieldName("REQUEST");
jsongen.writeStartObject();     
jsongen.writeFieldName("ID");
jsongen.writeStartArray();
jsongen.writeNumber(request.getRequest().getID());
jsongen.writeEndArray();
jsongen.writeEndObject();
jsongen.writeEndObject();
jsongen.close();