// (...)
Paintable doorAsPaintable = (Paintable) context.getBean(Door.class);
Openable doorAsOpenable = (Openable) doorAsPaintable;

Class<?> dynamicProxyClass = doorAsPaintable.getClass();
System.out.println("Dynamic proxy: " + dynamicProxyClass);
System.out.println("Dynamic proxy parent: " + dynamicProxyClass.getSuperclass());
System.out.println("Dynamic proxy interfaces: " + Arrays.asList(dynamicProxyClass.getInterfaces()));
// (...)