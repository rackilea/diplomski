@Autowired
Neo4jTemplate template;

public Country save(Country country){
    return template.save(country);
}