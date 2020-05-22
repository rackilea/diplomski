ShapeHolder sh = new ShapeHolder();
 sh.addShape(new Rectangle());
 sh.addShape(new Circle());
 JSONSerializer ser = new JSONSerializer();
 String json = ser.deepSerialize(sh);
 JSONDeserializer<ShapeHolder> der = new JSONDeserializer<ShapeHolder>();
 ShapeHolder sh2 = der.deserialize(json);