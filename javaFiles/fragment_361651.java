Iterator<String> iterator;
    try {
        iterator = getAttributes(new File("..."));
    } catch (ParserConfigurationException | SAXException | IOException e) {
        e.printStackTrace();
        return;
    }
    ArrayList<Employee> pArray = new ArrayList<SettingForm>();
    try {
        URL url = new URL(urlLink);
        BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line= input.readLine()) != null){
            String[] value = line.split("=");
            if(value.length > 1){
                pArray .add(new Employee(value[0], value[1], iterator.next(), iterator.next(), iterator.next()));
            }
        }
        input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
    }