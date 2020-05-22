ObjectWriter jsonMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
String displayJson = null;
try {
    displayJson = jsonMapper.writeValueAsString(applicationParametersForPrivilege);
} catch (Exception e) {
    e.printStackTrace();
}