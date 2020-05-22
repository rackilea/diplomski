public interface MainInterFace{

    public interface CallBackInterface{
         public void getInt(int output);
    }

    public void registerCallBackInterFace(CallBackInterface callBacks);

    public void getResultFromFaceBook();
}