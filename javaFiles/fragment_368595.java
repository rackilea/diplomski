List result = new ArrayList();
 Field[] f = <your object>.getClass().getDeclaredFields();
 for (int i = 0; i < f.length; i++) {
     if (!Modifier.isStatic(f[i].getModifiers())) {
         result.add(f[i]);
     }
 }

 return result.iterator();