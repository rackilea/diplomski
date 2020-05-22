public void save() {

try {
        A a = new A();
        ObjectMapper mapper = new ObjectMapper();
        String temp = mapper.writeValueAsString(a);

    } catch (JsonGenerationException e) {
       e.printStackTrace();
    } catch (JsonMappingException e) {
       e.printStackTrace();
    } catch (IOException e) {
       e.printStackTrace();
    }

}