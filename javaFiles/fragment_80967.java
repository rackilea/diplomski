@Override
public List<FrequencyCode> findAllWithFilters(String name, Boolean allowExplicitDosingTimes) {

  FrequencyCode fc = new FrequencyCode();         
  //I assume that you have setters like bellow                 
  fc.setName(name);
  fc.setAllowExplicitDosingTimes(allowExplicitDosingTimes);                           

  ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();                        

  Example<FrequencyCode> example = Example.of(fc, matcher);

  return ((FrequencyCodeRepository) baseRepository).findAll(example);
}