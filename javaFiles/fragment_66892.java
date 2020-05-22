Map<String, Object> map = new HashMap<>();
    map.put("a", "b");
    map.put("c", 3);
    map.put("d", new Date());


    ser.write(map, new File("test2.xml"));