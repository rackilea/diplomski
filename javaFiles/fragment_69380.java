public class AlarmDetailsActivity extends Activity
    DialogFragmentOtherMedia.YesNoListener {

    //All of your activity stuff here...

    @Override
    public void onYesOtherMedia(int result) {
        Log.i("Tag", "onYes Result: " + result);
    }

    @Override
    public void onNoOtherMedia(int result) {
        Log.i("Tag", "onNo Result: " + result);

    }



}