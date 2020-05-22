class MyObject {
    private String key1, key2;
    private KEY3 key3;
}

class KEY3 {
    private SUBKEY3 subkey1;
    private SUBKEY3 subkey2;
    // getters and setters
}

class SUBKEY3 {
    private String subsubkey1;
    private String subsubkey2;
}

...

MyObject data = new Gson().fromJson(jsonString, MyObject.class);
System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(data));