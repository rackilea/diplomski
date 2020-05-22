Image myImage = ...;
Vector2 coords = new Vector2(myImage.getX(), myImage.getY());
myImage.localToStageCoordinates(/*in/out*/coords);
myImage.getStage().stageToScreenCoordinates(/*in/out*/coords);

System.out.println("Image X " +myImage.get()+ " maps to screen " +coords.x);