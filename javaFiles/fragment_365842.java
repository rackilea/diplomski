List<Person> people = ...;

List<String> ids = Lists.transform(people, new Function<People, String>(){
     public String apply(People person){
         return person.getId();
     }    
});