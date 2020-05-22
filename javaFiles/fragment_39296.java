Timeline tl = new Timeline(new KeyFrame(Duration.millis(3000), ae -> {
     Car car=new Car();
     cars.add(car);
     root.getChildren().add(car.drawCar());
 }));
 tl.setCycleCount(10);
 tl.play();