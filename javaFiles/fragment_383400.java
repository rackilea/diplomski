public void testBuildSqlToDoXYZ() throws Exception {

   WhateverYourObjectIs yourObject = new WhateverYourObjectIs();
   MyConfig myConfig = new MyConfig();
   myConfig.setABC("foo");

   String sql = yourObject.getSqlToDoXYZ(myConfig);
   assertEquals("SELECT BLAH BLAH WHERE ABC='foo'", sql);

}