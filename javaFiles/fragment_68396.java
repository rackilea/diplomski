public class Demo {
  public static void main(String[] args) {
    final ApplicationContext springAppContext = new AnnotationConfigApplicationContext(SpringConfig.class);
    final Mapper dozerMapper = springAppContext.getBean("demoDozerMapper", DemoDozerMapper.class);

    final Author authorModel = new Author();

    // Ensure base model is set
    BaseModel baseModel = new BaseModel();
    baseModel.setCreatedBy(Long.valueOf(1L));
    baseModel.setCreatedTimestamp(new Timestamp(System.currentTimeMillis()));
    authorModel.setBaseModel(baseModel);

    authorModel.setFirstName("First");
    authorModel.setLastName("Last");
    authorModel.setId(Long.valueOf(21101L));

    final AuthorPojo author = new AuthorPojo();

    // Select the appropriate case to use
    dozerMapper.map(authorModel, author, "authorMap");
    System.out.println("Author Pojo: " + author);
  }
}