AndroidJavaObject myClass = null;

public void Init () {
    if(myClass == null)
        myClass = new AndroidJavaObject("com.myCompany.myProduct.MyClass");

    if(myClass != null)
        myClass.Call("init", new object[0]);
}


public void MakeToast (string toastText, int duration) {
    if(myClass != null)
        myClass.Call("makeToast", new object[] { toastText, duration } );
}