//*****Data*****//
public class Data {
    @SerializedName("key1")
    private String key1;

    @SerializedName("key2")
    private String key2;

    // Getters and Setters
}

//*****Callback Implementation*****//
public class MyDataCallback extends Callback {
   public MyDataCallback(MyDataCallbackListener<List<Data>> myDataCallbackListener) {
        super(myDataCallbackListener);
    }

    @Override
    public void success(List<Data> data, Response response) {
        if (myDataCallbackListener != null) {
            myDataCallbackListener.onCallbackComplete(true, response, MyDataCallback.CALLBACK_SUCCESS_MESSAGE, data);
        }
    }
}