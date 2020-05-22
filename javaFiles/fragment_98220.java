public static class FolderMainPageFragment extends Fragment {

    TextView title;
    boolean bindExceptionally = false;
    MainListItem currListItem;

    public static FolderMainPageFragment newInstance(String text) {
        return new FolderMainPageFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_list_item_view_folder, container, false);
        this.title = (TextView) v.findViewById(R.id.list_title);

        if(bindExceptionally) {
            title.setText(currListItem.oTitle);
            bindExceptionally = false;
            currListItem = null;
        }

        return v;
    }
}