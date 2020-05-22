@Test
public void testCalculate() {
    Item item = new Item();

    Article article = new Article();
    Article articleSpy = Mockito.spy(article);

    Mockito.doReturn(item).when(articleSpy).prepareItem();
    article.calculate();
}