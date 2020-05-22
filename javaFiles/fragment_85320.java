Item item = Mockito.mock(Item.class);
Mockito.when(item.getInfo()).thenReturn("bla bla");

Article article = Mockito.spy(Article.class);
Mockito.doReturn(item).when(article).prepareItem();
article.calculate();