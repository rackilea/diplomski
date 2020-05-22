ObjectPropertiesStore store = new ObjectPropertiesStore();

// write the object to the store        
store.writeObject(new Foo());

// let's get the Properties object and print the contents to System.out
Properties properties = store.getDatabase();
properties.store( System.out, "My test");