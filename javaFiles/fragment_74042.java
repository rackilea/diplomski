Properties prop = new Properties();
prop.load(new FileInputStream( path ));

Map<String, String> mapProp = prop.entrySet().stream().collect(
    Collectors.toMap(
        e -> (String) e.getKey(),
        e -> (String) e.getValue()
    ));