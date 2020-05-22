public ArrayList<MyInterface> getMyInterfaces() {
    // Note the change here
    ArrayList<MyInterface> myPojos = new ArrayList<MyInterface>(0);
    myPojos.add(new MyPojo(0));
    myPojos.add(new MyPojo(1));

    return myPojos;
}