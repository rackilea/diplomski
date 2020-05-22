public class MyListHandler {

    List<MyDataType> myList;
    public MyListHandler(List<MyDataType> myList){
        this.myList = myList;
    }

    public void printList(){
        for (MyDataType item: myList) {
            System.out.println(item);
        }
    }

    public void clearList(){
        System.out.println("My list size: " + myList.size());
        myList.clear();
        System.out.println("My list size after clear: " + myList.size());
    }

}