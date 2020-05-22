FileInputStream infile = new 
    FileInputStream("pathtofile");

ObjectInputStream inobj = 
    new ObjectInputStream (infile);

Object obj = inobj.readObject();

MyWrapper myWrapperInstance = (MyWrapper) obj;