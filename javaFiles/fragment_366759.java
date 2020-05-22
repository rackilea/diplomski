@Test
public void test() {
    getJson("classpath:sample.json");
}

public JSON getJson(String path) {
    File file = null;
    try {
        file = ResourceUtils.getFile(path);
        //Read File Content
        String content = new String(Files.readAllBytes(file.toPath()));
        //Get a Json String
        System.out.println(content);
        JSON json = JSON.parseObject(content);
        return json;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}