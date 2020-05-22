public class DemoObject {

    private int mSomeInt;
    private String mSomeString;

    public DemoObject(int i, String s) {

        mSomeInt = i;
        mSomeString = s;
    }

    //... other stuff

    public JSONObject toJSON() {

        JSONObject jo = new JSONObject();
        jo.put("integer", mSomeInt);
        jo.put("string", mSomeString);

        return jo;
    }
}