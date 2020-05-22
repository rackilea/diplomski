class MyMutableObject {
    public int theValue;
}

class Test {

    private static MyMutableObject[] theList;

    static {
        theList = new MyMutableObject[4094];
        for (int i = 1; i <= 4094; i++) {
            theList[i-1] = new MyMutableObject();
            theList[i-1].theValue = i;
        }
    }

    public static void main(String [] args) {
        Queue<MyMutableObject> que = new LinkedList(Arrays.asList(theList));
        System.out.println(que.peek().theValue); // 1
        // your actually modifing the same object as the one in your static list
        que.peek().theValue = -100; 
        Queue<MyMutableObject> que2 = new LinkedList(Arrays.asList(theList));
        System.out.println(que2.peek().theValue); // -100
    }
}