ConvertStringToUpperCase t = new ConvertStringToUpperCase();
for(Field f: t.getClass().getDeclaredFields()) {            
    if(f.getType().equals(String.class)) {              
        f.setAccessible(true);
        f.set(t, ((String)f.get(t)).toUpperCase());
    }           
}