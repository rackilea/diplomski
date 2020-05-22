Class<?> thisClass = Class.forName("Point", true, classLoader);
Object iClass = thisClass.newInstance();
...
ObservableList<Object> data = FXCollections.observableArrayList();
data.addAll(iClass);

// Sample Point class method
Method getXMethod = thisClass.getDeclaredMethod("getX");

System.out.println(getXMethod.invoke(data.get(0)));