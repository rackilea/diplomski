// Group for the two rectangles
Group group = new Group();

double width = 430.0;
double percentage = 0.33;

// Your background image rectangle
Rectangle background = new Rectangle(0, 0, width, 30);
background.setFill(imagePattern);
background.setStroke(Color.rgb(1,1,1,0.88));
background.setStrokeWidth(0.88);

// Second rectangle to cover parts of the background
Rectangle rect = new Rectangle(percentage * width, 0, (1 - percentage) * width, 30);
rect.setFill(Color.WHITE);
rect.setStroke(Color.rgb(1,1,1,0.88));
rect.setStrokeWidth(0.88);

// Group the two rectangles together
group.getChildren().add(background);
group.getChildren().add(rect);

// ... show the group.