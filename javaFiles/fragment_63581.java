Object o = ...; // The object you want to inspect
Class<?> c = o.getClass();

Field f = c.getDeclaredField("myColor");
f.setAccessible(true);

String valueOfMyColor = (String) f.get(o);