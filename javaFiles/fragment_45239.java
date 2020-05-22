boolean pressed = false;  

    scene.setOnMousePressed((MouseEvent event) -> {
         pressed = true;
         newX = event.getSceneX();
         newY = event.getSceneY();
    });

    scene.setOnMouseMoved((MouseEvent event) -> {
        if(pressed){
             oldX = newX;
             oldY = newY;
             newX = event.getSceneX();
             newY = event.getSceneY();
             dx = newX -oldX;
             dy = newY -oldY;

             camera.setTranslateX(camera.getTranslateX() - dx*0.1);
             camera.setTranslateY(camera.getTranslateY() - dy*0.1);      
        }           
    });