public ArrayList<? extends MyInterface> getMyInterfaces() {    
    ArrayList<MyPojo> myPojos = new ArrayList<MyPojo>(0);
    myPojos.add(new MyPojo(0));
    myPojos.add(new MyPojo(1));

    return myPojos;
}