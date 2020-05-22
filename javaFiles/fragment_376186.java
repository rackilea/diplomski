public GrammerStack(String structureName, int limit){
  super(structureName);
  this.structName = structureName; 
  this.cap = limit; 
  System.out.println(structName+"["+cap+"]");
}