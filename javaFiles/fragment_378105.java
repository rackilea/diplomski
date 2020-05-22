@POST
@Consumes("multipart/*")
public String create(MultiPart multiPart) throws Exception {
    String message;
    try (BodyPartEntity bpe 
                = (BodyPartEntity) multiPart.getBodyParts().get(0).getEntity()) {
        message = getString(bpe.getInputStream());
    }
    return message;
}

private String getString(InputStream is) throws Exception {
    StringBuilder builder = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
        String line;
        while((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
    }
    return builder.toString();
}