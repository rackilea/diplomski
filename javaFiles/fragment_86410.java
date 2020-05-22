ObjectMapper mapper = new ObjectMapper();

// create filter with id "DEFAULT_FILTER" and configure it to exclude 'createdDate' property.
FilterProvider filters = new SimpleFilterProvider().addFilter("DEFAULT_FILTER",
SimpleBeanPropertyFilter.serializeAllExcept("createdDate"));

JacksonAnnotationIntrospector jai = new CustomIntrospector ();

// plug the custom annotation that will use "DEFAULT_FILTER" if the pojo doesn't have @JsonFilter annotation.
String jsonPerson = mapper.setAnnotationIntrospector(jai).writer(filters).writeValueAsString(new Person());
String jsonUser = mapper.setAnnotationIntrospector(jai).writer(filters).writeValueAsString(new User());