class MyMain {
    public static void main (String[] args) {
        MyObject[] objects = new MyObject[] {new MyInteger(1),
                                             new MyInteger(2),
                                             new MyInteger(3),
                                             new MyString("test1"),
                                             new MyString("test2"),
                                             new MyString("test3"),
                                             new MyLong(4L)};
        for (MyObject o: objects) {
            o.accept( new PrintMyObjectsVisitor() );
        }
    }
}