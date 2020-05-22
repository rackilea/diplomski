class MyObj {
    int a;
    char b;

    MyObj(int a, char b) {
        this.a = a; this.b = b;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyObj){
            MyObj myobj = (MyObj) obj;
            if(myobj.a == a && myobj.b == b){
                return true;
            }
        }
        return false;
    }
}