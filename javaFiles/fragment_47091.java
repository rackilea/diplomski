String foo = Optional.ofNullable(getFoo(storedProcedureResult))
                     .map(String::trim).orElse("");
if(!foo.isEmpty()){
  if(foo.substring(1).equals("bar")){ 
  } else if(foo.substring(4,6).equals("bar")){ 
  }
}