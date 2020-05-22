@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_chat, container, false);

    RecyclerView chatList = (RecyclerView) view.findViewById(R.id.recycler_chat_list);
    chatList.setHasFixedSize(true);
    chatList.addItemDecoration(new DividerItemDecoration(getActivity(),
            DividerItemDecoration.VERTICAL_LIST));
    chatList.setLayoutManager(new LinearLayoutManager(getActivity()));
    chatList.setAdapter(mChatAdapter);

    mTextEmptyChatList = (TextView) view.findViewById(R.id.text_empty_chat_list);

    FloatingActionButton fabCreateChat = (FloatingActionButton)
            view.findViewById(R.id.fab_create_chat);
    fabCreateChat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showContact();
        }
    });

    return view;    //return here
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
}