try {
     field.setAccessible(true);
     Object value = field.get(<your object>);
     <String buffer of your generic toString representation>.append(value);
 } catch (IllegalAccessException e) {
     // e.printStackTrace() obviously
 }