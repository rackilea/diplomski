InputStream input = new FileInputStream(new File("path_to_your_file"));
ArrayList<ArrayList> list = (ArrayList<ArrayList>) new Yaml().load(input);

Object[][] data = list.stream()
        .map(dataSet -> dataSet.toArray())
        .toArray(Object[][]::new);