@Override
public void onStart() {
    super.onStart();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference groupChatsRef = rootRef.child("Group Chats");
    FirebaseRecyclerAdapter<String, GroupChatViewHolder> chatAdapter = new FirebaseRecyclerAdapter<String, GroupChatViewHolder>(
            String.class,
            R.layout.layout_groups,
            GroupChatViewHolder.class,
            groupChatsRef) {
        protected void populateViewHolder(GroupChatViewHolder viewHolder, String model, int position) {
            final String groupChatName = this.getRef(position).getKey();
            viewHolder.setName(groupChatName);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentUserProfile = new Intent(getActivity(), ChatActivity.class);
                    intentUserProfile.putExtra("groupChatName", groupChatName);
                    intentUserProfile.putExtra("neighbourhood", neighbourhood);
                    intentUserProfile.putExtra("usersName", usersName);
                    intentUserProfile.putExtra("usersID", usersID);
                    startActivity(intentUserProfile);
                }
            });
        }
    };
    jGroupChatList.setAdapter(chatAdapter);
}