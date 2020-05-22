class Beastie {
   @Parent
   @Load
   ParentThing parent;

   @Id Long id;

   @Load({"bigGroup", "smallGroup"})
   SomeThing some;

   @Load("bigGroup")
   List<OtherThing> others;

   @Load
   Ref<OtherThing> refToOtherThing;

   Ref<OtherThing> anotherRef;  // this one is never fetched automatically
}