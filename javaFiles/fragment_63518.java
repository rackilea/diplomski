public class Inner1Fragment extends Fragment {

    // Call this method when you want to pass data to outer fragment (such as users press on a button on this fragment)
    private void onButtonClick() {
        // Pass the message to OuterFragment.
        OnMessageListener listener = (OnMessageListener) getParentFragment();
        listener.onMessage("Message from Inner1Fragment");
    }

    // Declare an interface to pass data to outer fragment.
    public interface OnMessageListener {
        void onMessage(String message);
    }
}