public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_profile_posts, container, false);
    mRecView = (RecyclerView) view.findViewById(R.id.lvProfilePosts);
    mFriends = new ArrayList<>();
    mPhotos = new ArrayList<>();

    mAdapter = new ViewProfilePostsAdapter(getActivity(), mPhotos);
    mRecView.setAdapter(mAdapter);
    getFriends();


    return view;
}