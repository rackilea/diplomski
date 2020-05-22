public class BlankFragment extends Fragment{
Messenger sender;
(...)

public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sender.sendMessage("Hello World");
    }