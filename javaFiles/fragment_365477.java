Gson gson = new Gson();

    try {

        BufferedReader br = new BufferedReader(
            new FileReader("c:\\file.json"));

        //convert the json string back to object
        DataObject obj = gson.fromJson(br, DataObject.class);

        System.out.println(obj);

    } catch (IOException e) {
        e.printStackTrace();
    }