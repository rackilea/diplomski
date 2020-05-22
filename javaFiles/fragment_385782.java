@Transactional(propagation = Propagation.REQUIRED)
void insert1() {
    TestModel testModel = new TestModel(1, "title1", "content1");
    mapper.insert(testModel);
    throw new RuntimeException();
}