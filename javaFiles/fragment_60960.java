Response res = target("test").request().get();
FormDataMultiPart multiPart = res.readEntity(FormDataMultiPart.class);
FormDataBodyPart jsonPart = multiPart.getField("json-data");
FormDataBodyPart filePart = multiPart.getField("file-data");

Model jsonData = jsonPart.getValueAs(Model.class);
InputStream file = filePart.getValueAs(InputStream.class);