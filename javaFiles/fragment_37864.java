FileInputStream file = new FileInputStream("pseudo.pxml");
ByteArrayOutputStream temp = new ByteArrayOutputStream();
int c = -1;

while ((c=file.read()) >= 0){
   temp.write(c);
}

String xml = new String(temp.toByteArray());
xml = xml.replaceAll("([^:\s]+:[^:\s]+)", "value=\"\\1\"");

ByteArrayInputStream xmlIn = new ByteArrayInputStream(xml.getBytes());

/* use xmlIn for your XML parsers */