String foo = getFoo(storedProcedureResult);
if(foo != null) foo = foo.trim();
if(foo !=null && !foo.isEmpty()){
  if(foo.substring(1).equals("bar")){ 
  } else if(foo.substring(4,6).equals("bar")){ 
  }
}