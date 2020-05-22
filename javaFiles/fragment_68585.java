public void setData(Object data) {
    try {
        this.data = (Object) data; //Obviously always works!
    } catch (ClassCastException e) {
        System.err.println("Cast" + e);  //This line never reached
    }
}