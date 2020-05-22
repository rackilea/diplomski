Scene mScene = new Scene();
mScene.setOnSceneTouchListener(this);

Rectangle rectangle = new Rectangle(x,y,width,height){
     public boolean onAreaTouch(){
          if(pSceneTouchEvent.isActionDown()){
               return true;
          }
          return false;
     }
};

mScene.registerTouchArea(rectangle);
mScene.attachChile(rectangle);

public boolean onSceneTouchEvent(){
      if(pSceneTouchEvent.isActionDown()){
           return true;
      } else if(pSceneTouchEvent.isActionUp()){
           return true;
      }
      return false;
}