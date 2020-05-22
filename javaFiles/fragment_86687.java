AlertDialog.Builder builder = new AlertDialog.Builder(Friends.this);
        final User user = usersList.get(position);

        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.your_dialog_layout, null);
        builder.setView(dialogView);

        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //myRef.child("Users").child(userId).child("FriendLists").child(friend.getName()).removeValue();
                //friendList.remove(friend);
                //mAdapter.notifyDataSetChanged();
            }
        });
        builder.show();