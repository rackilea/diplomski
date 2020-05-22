filterExpr = "(&(objectclass=person)(|(memberOf={0})(memberOf={1})(memberOf={2})))";
String rol1 = "myRol1";
String rol2 = "myRol2";
String rol3 = "myRol3";
Object parameters[] ={rol1, rol2, rol3);
context.search(distinguishedName, filterExpr, parameters, controls);