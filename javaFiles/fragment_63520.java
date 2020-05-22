public class Inner2Fragment extends Fragment {

    public void onReceiveMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}