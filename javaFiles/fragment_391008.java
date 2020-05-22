public void writeEveryting(So so) {
    ObjectMapper mapper = new ObjectMapper();
    FilterProvider filters = new SimpleFilterProvider()  
      .addFilter("filterByName", SimpleBeanPropertyFilter.serializeAllExcept(""));  
    ObjectWriter writer = mapper.writer(filters);  
    try {
        System.out.println(writer.writeValueAsString(so));
    } catch (Exception e) {
        e.printStackTrace();
    }
}