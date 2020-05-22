XmlMapper xmlMapper = new XmlMapper();
File file = new File("example.xml");
BESAPI besApi = xmlMapper.readValue(file, BESAPI.class);
for (Employee employee : besApi.getEmployees()) {
    System.out.println(employee.getResource());
}