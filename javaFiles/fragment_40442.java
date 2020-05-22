public void foo(){
    myWrapper wrapper = (myWrapper) Native.loadLibrary("SomeDllWithLegacyCode", myWrapper.class);

    myClass myObj = new myClass();
    myObj.x = 1;
    myObj.y = 2;

    int size = Native.getNativeSize(myClass.class);
    IntByReference len = new IntByReference(size);

    //log len.getValue
    wrapper.myCfunc(myObj, len);
    //log len.getValue
}