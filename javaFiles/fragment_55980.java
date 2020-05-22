public class TabFragment extends ListFragment {

@Override
      public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TabelAdapter adapt = new TabelAdapter(getActivity().getApplicationContext(), R.layout.list_room_view, flowerList);
        setListAdapter(adapt);
       }
     ...
    }