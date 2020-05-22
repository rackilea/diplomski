public class MasterFragment extends ListFragment {

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container);

        setListAdapter(new MenuListAdapter(R.layout.row_menu_action_item, getActivity(), MenuActionItem.values()));
        return view;
    }

@Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);

            if(position == 0){
                SMSFragment smsFragment = new SMSFragment();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(
                        R.id.layout_main,
                        smsFragment,
                        smsFragment.getTag()
                ).commit();
            }
        }
}