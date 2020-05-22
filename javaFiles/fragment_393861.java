class SomeDto implements Dto<SomeDtoAttribute> {
   class SomeDtoAttributes implements DtoAttributes {
      String name;
      date created;
   }

   String id;
   SomeDtoAttributes attributes;
}