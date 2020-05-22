public class GameController{
  List<ObjectInMyGame> objects;

  public updateGame(){
    for (ObjectInMyGame object : objects){
      object.doSomething(); //sometimes it is good idea to let objects itself do something
    }
  }
}