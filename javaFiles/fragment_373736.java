private Object  _specialObjectFromHttp;

public void methodToUse() {
    Thread thread = new Thread(new Runnable() {
        getParamsFromHttp();
        _specialObjectFromHttp.wait();
    )};
}

// Callback method (Thread wait for this.)
private void getParamsFromHttpCallBack(Object result) {
    _specialObjectFromHttp = result;
    _specialObjectFromHttp.notifyAll();
}