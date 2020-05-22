import java.util.*;

public class HelloWorld
{
  public static void main(String[] args)
  {
    BoxDB boxDB = new BoxDB();
    List<BlueBox> boxList = boxDB.<BlueBox>getBoxList("123");
    for (IBox box: boxList) {
        System.out.println(box.getClass().getName());//prints "RedBox"
    }
  }
}

interface IBox {
    String getKey();
}

class RedBox implements IBox {
  String key;
  public RedBox(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}

class BlueBox implements IBox {
  String key;
  public BlueBox(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }
}

class BoxDB
{
  public <B extends IBox> List<B> getBoxList(String key) {
    List<B> result = new ArrayList<>();
    result.add((B)new RedBox("123"));
    return result;
  }
}