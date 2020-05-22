private static MainActivity instance;

@Override
protected void onStart() { // onStart() of your activity
    super.onStart();
    instance = this;
}

public void yourMethod(){
    // Your code here
}

public static MainActivity getInstance(){
    return instance;
}