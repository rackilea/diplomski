public class HomeshelfFragment extends Fragment {

public static final String KEY_DATA = "KEY_DATA";
private ArrayList<SingleHomeCardItem> myCards;



public static HomeshelfFragment newInstance(String data) {

    HomeshelfFragment f = new HomeshelfFragment();
    Bundle b = new Bundle();
    b.putString(KEY_DATA, data);
    f.setArguments(b);

    return f;
}

private View createView(LayoutInflater inflater, ViewGroup container, SingleHomeCardItem[] items) {
        View v = inflater.inflate(<your layout>, container, false);

        String dataString = this.getArguments().getString(KEY_DATA, "");

    AccountData data = null;

        myCards = new ArrayList<SingleHomeCardItem>();
    try {
        data = new AccountData(datastring);
    } catch (JSONException e) {

        e.printStackTrace();
    }


    try {
                  // a list with your SingleHomeCardItem instances
        myCards = data.getAcountCards();

    } catch (JSONException e) {

        e.printStackTrace();
    }
         // add views to the inflated view based on models data
    return v;
}