FileResolver fileResolver = new FileResolver() {
@Override
public File resolveFile(String fileName) {
 URI uri = null;
 try {
uri = new URI(this.getClass().getResource("/" + fileName).getPath());
 } catch (URISyntaxException e) {
 }
return new File(uri.getPath());
}
};

HashMap<String, Object> parameters = new HashMap<String, Object>();

parameters.put("logoPath", "\\logo.jpg");
parameters.put("companyName", "Company Name");
parameters.put("REPORT_FILE_RESOLVER", fileResolver);
...
print = JasperFillManager.fillReport(report, parameters,
new JREmptyDataSource());