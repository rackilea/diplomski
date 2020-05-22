public void Set(String interface_name, String property_name, Variant new_value) throws Exception {
     Type t = new_value.getType();
     Object s = new_value.getValue();
     ((Class)t).cast(s); 
     System.out.println("Object cast to "+s.getClass().getName());
}