public View onCreateView (
    LayoutInflater inflater,
    ViewGroup container,
    Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_first,container, false);

invitesGridView = (GridView)view.findViewById(R.id.invitesGridView);
final inviteListAdapter adapter = new inviteListAdapter(this,inviteFriendList);
invitesGridView.setAdapter(adapter);
adapter.notifyDataSetChanged();

        return view;
 }