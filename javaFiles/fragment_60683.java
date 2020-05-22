public class Test extends Fragment {
    ...
    // Call this method when the condition is met.
    public void broadcastIntent() {
        Intent intent = new Intent();
        intent.setAction("com.example.Broadcast");
        getActivity().sendBroadcast(intent);
    }
}