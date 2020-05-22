// you need to add a dependency (if you don't have it already) for com.fasterxml.jackson.core:jackson-databind
ObjectMapper mapper = new ObjectMapper();

private void processResource(Resource resource) {
    try {
          Map<String, Object> jsonMap = mapper.readValue(resource.getInputStream(), Map.class);

          // do stuffs with your jsoMap

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}