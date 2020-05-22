public class Activity2 extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // showToastMessage = false; // want to avoid here
       super.onCreate(savedInstanceState);// I always want this in first line of onCreate
    }

    public void showToast(String message) {
       // do nothing
    }
}