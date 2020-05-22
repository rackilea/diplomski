Map<String, BigDecimal> test = new TreeMap<>();
    test.put("Test", BigDecimal.ZERO);
    test.put("Test2", BigDecimal.ONE);
    test.put("Test3", null);

    Gson gson = new Gson();

    Type mapType = new TypeToken<HashMap<String, Integer>>() {}.getType();
    System.out.println(gson.toJson(test, mapType));

    Gson gson2 = new GsonBuilder().serializeNulls().create();
    System.out.println(gson2.toJson(test, mapType));