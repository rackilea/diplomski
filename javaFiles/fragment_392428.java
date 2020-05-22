public void saveParamChanges() {
   try {
     // create and set properties into properties object
     Properties props = new Properties();
     props.setProperty("Prop1", "toto");
     props.setProperty("Prop2", "test");
     props.setProperty("Prop3", "tata");
     // get or create the file
     File f = new File("app-properties.properties");
     OutputStream out = new FileOutputStream( f );
     // write into it
     DefaultPropertiesPersister p = new DefaultPropertiesPersister();
     p.store(props, out, "Header COmment");
   } catch (Exception e ) {
    e.printStackTrace();
   }
}