ObjectMapper m = new ObjectMapper();

String json = "{\"field1\":null,\"field2\":20}";
Data data = m.readValue(json, Data.class);

System.out.println(data); // Data [field1=null, field2=20, field3=3.75]

System.out.println("field1 default ? " + data.isDefault(Data::getField1)); // false
System.out.println("field1 null ? " + data.isNull(Data::getField1)); // true
System.out.println("field1 set ? " + data.isSet(Data::getField1)); // false

System.out.println("field2 default ? " + data.isDefault(Data::getField2)); // false
System.out.println("field2 null ? " + data.isNull(Data::getField2)); // false
System.out.println("field2 set ? " + data.isSet(Data::getField2)); // true

System.out.println("field3 default ? " + data.isDefault(Data::getField3)); // true
System.out.println("field3 null ? " + data.isNull(Data::getField3)); // false
System.out.println("field3 set ? " + data.isSet(Data::getField3)); // false