// on setup:

 BeanAdapter<Article> adapter = new BeanAdapter<Article>((Article)null,
    false);
 // the "false" in the constructor means don't try to observe property
 // changes within the Article, but we still can observe changes
 // if the Article itself is replaced with a new one.

 JTextField tfAuthors = BasicComponentFactory.createTextField(
     adapter.getValueModel("authors"));
 JTextField tfTitle = BasicComponentFactory.createTextField(
     adapter.getValueModel("title"));