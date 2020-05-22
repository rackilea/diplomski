public class TabContent {
  private static final Image ncpic = new Image(
    TabContent.class.getResource(
      "/images/6.jpg"
    ).toExternalForm()
  );

  private static StackPane generalConfiguration() {
    StackPane stack = new StackPane(); 
    stack.getChildren().addAll(new ImageView(ncpic));  

    return stack;
  }
}