Matcher m = Pattern.compile("(https?://[^/]+)").matcher(//
        "WEBSITE1 https://localhost:8080/admin/index.php?page=home\r\n" + //
        "WEBSITE2 https://192.168.0.3:8084/index.php\r\n" + //
        "WEBSITE3 https://192.168.0.5:9090/controller/index.php?page=home\r\n" + //
        "WEBSITE4 https://192.168.0.1:8080/home/index.php?page=forum");
List<String> urls = new ArrayList<String>();
while (m.find()) {
    urls.add(m.group(1));
}
System.out.println(urls);