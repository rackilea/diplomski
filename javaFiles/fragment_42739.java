...
myImageView = new ImageView();  
myImageView.setFitWidth(500);
myImageView.setPreserveRatio(true);

button.setOnAction(e ->
{
  ...
});

FadeTransition ft = new FadeTransition(Duration.millis(1000), myImageView);