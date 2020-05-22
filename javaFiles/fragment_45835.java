MyObject ob1 = new MyObject();
MySecondObject ob2 = new MySecondObject();

//Here we write locally the data object
Storage.getInstance().writeObject("myObject1", ob1);
Storage.getInstance().writeObject("myObject2", ob2);

//Here we read it to get it back (Caution : We ask storage if the object exist) 
MyObject ob1Back = Storage.getInstance().exists("myObject1")?(MyObject) Storage.getInstance().readObject("myObject1"):new MyObject();
MySecondObject ob2Back = Storage.getInstance().exists("MySecondObject")?(MySecondObject) Storage.getInstance().readObject("MyObject2"):new MySecondObject();