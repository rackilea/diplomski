public class Common
{
    OnSelectedListener mCallback = new OnSelectedListener(){
        public void getFailureDialog(){
            JOptionPane.showMessageDialog(null, "An Error Has Occurred.");
        }
    };


    public interface OnSelectedListener 
    {
        public void getFailureDialog();
    }

    public void myRecord(String email)
    {
        mCallback.getFailureDialog();  //now this works.
    }
}