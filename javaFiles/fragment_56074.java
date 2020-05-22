public TestElement<?> test(){
  Optional<Long> response =  Optional.of(5L);
  Optional< TestElement<?> > opResult = response.map( (element) -> mapAux(50L) );

  TestElement<?> result = opResult.orElseGet( () -> orElseGetAux(20L) );

  return result;
}