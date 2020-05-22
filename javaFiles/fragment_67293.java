import java.beans.*

for (PropertyDescriptor pd : Introspector.getBeanInfo(Foo.class).getPropertyDescriptors()) {
  if (pd.getReadMethod() != null && !"class".equals(pd.getName()))
    System.out.println(pd.getReadMethod().invoke(foo));
}