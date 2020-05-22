import java.util.ArrayList;

public class MyListClass {

  private ArrayList<String> list = new ArrayList<>();
  private static ArrayList<String> staticList = new ArrayList<>();

  public MyListClass(int instance) {
    for(int i = 0; i < instance; i++) {
        list.add(instance + ":" +i);
        staticList.add(instance + ":" +i);
    }
  }

  public ArrayList<String> getList() {
    return list;
  }

  public ArrayList<String> getStaticListList() {
    return staticList;
  }

}

public class MyInstanceClass {

  private int instance;
  private MyListClass listClass;

  public MyInstanceClass(int instance) {
    this.instance = instance;
    listClass = new MyListClass(instance);
  }

  public void showMeWhatYourListLooksLike() {
    System.out.println(String.format("For instance %d, the list has the following info: %s", instance, listClass.getList().toString()));
  }

  public void showMeWhatYourStaticListLooksLike() {
    System.out.println(String.format("For instance %d, the STATIC list has the following info: %s", instance, listClass.getStaticListList().toString()));
  }


  public void createAnotherInstance() {
    MyInstanceClass anotherInstance = new MyInstanceClass(30);
    anotherInstance.showMeWhatYourListLooksLike();
  }

}

public class MyMainClass {

  public static void main(String...args) {
    MyInstanceClass myInstanceClass01 = new MyInstanceClass(1);
    MyInstanceClass myInstanceClass05 = new MyInstanceClass(5);
    MyInstanceClass myInstanceClass10 = new MyInstanceClass(10);

    myInstanceClass01.showMeWhatYourListLooksLike();
    myInstanceClass05.showMeWhatYourListLooksLike();
    myInstanceClass10.showMeWhatYourListLooksLike();

    myInstanceClass01.showMeWhatYourStaticListLooksLike();
    myInstanceClass05.showMeWhatYourStaticListLooksLike();
    myInstanceClass10.showMeWhatYourStaticListLooksLike();

    myInstanceClass10.createAnotherInstance();
  }

}