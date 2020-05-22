ByteArrayOutputStream baos = new ByteArrayOutputStream();
beanWriter = new CsvBeanWriter(new PrintWriter(baos), DELIMITER);

//write some stuff

byte[] byteArray = baos.toByteArray();

return new ByteArrayInputStream(byteArray);