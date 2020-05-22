public class MyObject {

    public float x;
    public float y;
    public int iD;
    public String myType;


    public MyObject (float x, float y, int iD, String myType)
    {
        this.myType = myType;
        this.iD = iD;
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return ("[iD="+iD+" x="+x+" y="+y +" type="+myType+"]");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof MyObject) {
            MyObject myObject = (MyObject) o;
            return myObject.iD == this.iD && myObject.myType.equals(this.myType);
        }

        return false;
    }
}