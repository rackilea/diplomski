final ArrayList<String> list = new ArrayList<String>();

class MyButtonImpl extends MyButton {
     final ArrayList<String> list;

     public MyButtonImpl(final ArrayList<String> list) {
         this.list = list;
     }

}

MyButton button = new MyButtonImpl(list);