public static void main(String[] args) {
    DocumentContext json = JsonPath.using(configuration).parse(jsonInput);
    String jayPath = "$..book[0].author";
    String tagValue = "ReplacedText";
    System.out.println(json.set(jayPath, tagValue).jsonString());
}