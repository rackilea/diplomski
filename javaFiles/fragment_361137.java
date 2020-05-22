Object inbound = ois.readObject();
if (inbound instanceof List<?>) {
  Type t = inbound.getClass().getGenericSuperclass();
  if (t instanceof ParameterizedType) {
    ParameterizedType pt = (ParameterizedType) t;
    for (Type p : pt.getActualTypeArguments()) {
      if (p instanceof TypeVariable<?>)
        System.out.println("Unknown");
      else
        System.out.println(p); /* Prints "interface Node" */
    }
  }
}