class MyObject {
   private static final versionUid = 1;
   private final int version;

   private String a, b, c, d; //plus getters/setters;

   public MyObject() {
     version = versionUid ; //needed if you want to load objects of different backward compatible versions and still know the version after deserialization
   }

   public int getVersion() {
     return version;
   }
}


MyObject readObjectOfVersion2 = ... ;//deserialize an object of version 1
if( readObjectOfVersion2.getVersion() > 1 ) {//assuming version 1 only has a,b,c and version 2+ has d as well    
  String d = readObjectOfVersion2.getD();
}