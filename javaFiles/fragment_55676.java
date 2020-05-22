ObjectMapper om = new ObjectMapper();
    om.registerModule(new JavaTimeModule());
    om.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    //withNano(0) added
    LocalDateTime ldt = LocalDateTime.now().withNano(0); 

    Map<String,Object> map = new HashMap<>();
    map.put("ldt", ldt);
    String json = om.writeValueAsString(ldt);
    System.out.println(json);