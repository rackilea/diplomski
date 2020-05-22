while(jp.nextToken() != JsonToken.END_OBJECT) {
    if(jp.currentToken() == JsonToken.FIELD_NAME) {
       switch (jp.getCurrentName()) {
           //...
           case "fieldA3":
             jp.nextToken();
             list=jp.readValueAs(new TypeReference<List<ClassB>>() {}));
           break;
       }
    }
}