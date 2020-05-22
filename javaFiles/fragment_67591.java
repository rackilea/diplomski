//javafx.scene.image.Image
Image image = new Image(inputStream);
//javafx.scene.image.ImageView
ImageView imageView = new ImageView();
imageView.setImage(image);
this.getChildren().add(imageView);