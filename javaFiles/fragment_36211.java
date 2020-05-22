scene.widthProperty().addListener( ( observable, oldWidth, newWidth ) ->
{
  final double spacerMargin = newWidth.doubleValue()
      - scene.getRoot().getChildrenUnmodifiable().stream().mapToDouble( node -> node.getLayoutBounds().getWidth() ).sum();
  FlowPane.clearConstraints( btn3 );
  FlowPane.setMargin( btn3, new Insets( 0, 0, 0, spacerMargin ) );
} );