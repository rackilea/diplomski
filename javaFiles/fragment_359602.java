@Autowired
ResourceLoader resourceLoader;  

Resource resource = resourceLoader.getResource("classpath:my-file.json");
if (resource.exists()) {
  // do one thing
} else {
  // do something else
}