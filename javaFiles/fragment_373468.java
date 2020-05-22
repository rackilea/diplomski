public class DozerMap {

   public static class ContainerA {
      private A a;
      public A getA() { return a; }
      public void setA(A a) { this.a = a; }
   }

   public static class ContainerB {
      private B b;
      public B getB() { return b; }
      public void setB(B b) { this.b = b; }
   }

   private static class A { };

   private static class B { };

   static class ConverterImpl extends DozerConverter<A, B> {

      ConverterImpl() {
         super(A.class, B.class);
      }

      @Override
      public B convertTo(A source, B destination) {
         Logger.getAnonymousLogger().info("Invoked");
         return destination;
      }

      @Override
      public A convertFrom(B source, A destination) {
         Logger.getAnonymousLogger().info("Invoked");
         return destination;
      }
   }

   public static void main(String[] args) {

      DozerBeanMapper mapper = new DozerBeanMapper();
      mapper.setCustomConverters(Collections.<CustomConverter> singletonList(new ConverterImpl()));
      BeanMappingBuilder foo = new BeanMappingBuilder() {

         @Override
         protected void configure() {
            mapping(ContainerA.class, ContainerB.class).fields("a", "b", FieldsMappingOptions.customConverter(ConverterImpl.class));
         }
      };
      mapper.setMappings(Collections.singletonList(foo));
      ContainerA containerA = new ContainerA();
      containerA.a = new A();
      ContainerB containerB = mapper.map(containerA, ContainerB.class);
   }
}