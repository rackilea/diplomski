.customize(new CustomMapper<> {
    void mapBToA(FakeBeanA a, FakeBeanB b) {
   if(b.fieldB instanceof NestedType) {
      a.fieldA2 = ((NestedType)b.fieldB).nestedField2;
   }
 }});