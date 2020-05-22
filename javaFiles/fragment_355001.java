String s = "{\"startDate\": \"2013-05-10\",\"endDate\": \"2013-05-19\",\"value\": \"value1.5\"}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TestPojo pojo = mapper.readValue(s, TestPojo.class);
        System.out.println(pojo);
        s = "{\"startDate\": \"2013-05-10\",\"endDate\": \"2013-05-19\",\"data\": \"data1.5\"}";

        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        pojo = mapper.readValue(s, TestPojo.class);
        System.out.println(pojo);