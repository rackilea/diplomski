ObjectMapper jsonMapper = new ObjectMapper();
String displayJson = null;
try {
    displayJson = jsonMapper.writeValueAsString(applicationParametersForPrivilege);
} catch (Exception e) {
    e.printStackTrace();
}