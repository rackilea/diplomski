String foo = nullToEmpty(getFoo(storedProcedureResult)).trim();
if(!foo.isEmpty()){
  if(foo.substring(1).equals("bar")){ 
  } else if(foo.substring(4,6).equals("bar")){ 
  }
}