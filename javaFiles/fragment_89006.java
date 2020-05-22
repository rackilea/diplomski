public static void main(String[] args) {
    // The path of your YAML file.
    final String fileName = "test.yml";
    ArrayList<String> key = new ArrayList<String>();
    ArrayList<String> value = new ArrayList<String>();
    Yaml yaml = new Yaml();

    try {
        InputStream ios = new FileInputStream(new File(fileName));

        // Parse the YAML file and return the output as a series of Maps and Lists
        Map< String, Object> result = (Map< String, Object>) yaml.load(ios);
        for (Object name : result.keySet()) {   

            key.add(name.toString());
            value.add(result.get(name).toString());    
        }

    } catch (Exception e) {
        e.printStackTrace();
    } 

     System.out.println(key + " " + value); }