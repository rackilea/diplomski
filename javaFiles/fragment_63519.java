public class OuterFragment extends Fragment implements Inner1Fragment.OnMessageListener {

    @Override
    public void onMessage(String message) {
        // Forward the message to Inner2Fragment
        Inner2Fragment fragment = (Inner2Fragment) getChildFragmentManager().findFragmentByTag("Inner2Fragment");
        if (fragment != null) {
            fragment.onReceiveMessage(message);
        }
    }
}