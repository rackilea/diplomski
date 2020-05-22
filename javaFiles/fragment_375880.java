MainClass obj = new MainClass();
    ObjectMapper mapper = new ObjectMapper();

    try {

        // Convert JSON string from file to Object
        ConfigDetails details = mapper.readValue(new File("properties.json"), ConfigDetails.class);
        System.out.println(details.getAppID());

        List entities = details.getEntities();
        for (Entity entity : entities) {
            System.out.println(entity.getName());
        }
    } catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }