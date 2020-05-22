String testString = "param1=value1&param2=value2&param3=value3&param4=value4&param5=value5";

String[] paramValues = testString.split("\\&");

for (String paramValue : paramValues) {

    System.out.println(paramValue.split("\\=")[1]);
}