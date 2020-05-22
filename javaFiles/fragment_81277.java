{"field1":"value1"}
Exception in thread "main" com.fasterxml.jackson.databind.JsonMappingException: Unsupported type: class stackoverflow.JacksonTracking$B
    at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:125)
    at com.fasterxml.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:2866)
    at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:2323)
    at stackoverflow.JacksonTracking.main(JacksonTracking.java:71)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:606)
    at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
Caused by: java.lang.UnsupportedOperationException: Unsupported type: class stackoverflow.JacksonTracking$B
    at stackoverflow.JacksonTracking$UnsupportedSerializer.serialize(JacksonTracking.java:52)
    at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:114)
    ... 8 more