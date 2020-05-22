@Override
        public boolean onItemLongClick(AdapterView<?> parent, final View view, final int position, long id) {
            new MaterialDialog.Builder(MainActivity.this)
                    .title("Remove" + " " + mUserFriends.get(position).getUsername().toUpperCase() + "?")
                    .content("Do you really want to remove" + " " + mUserFriends.get(position).getUsername().toUpperCase() + " " + "from your friends list?")
                    .positiveText(R.string.dialog_yes)
                    .negativeText(R.string.dialog_no)
                    .callback(new MaterialDialog.ButtonCallback() {
                        // FIXME: 8/25/2015
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                           ParseQuery<ParseObject> query = ParseQuery.getQuery("Friend");
                           query.whereEqualTo("user", mCurrentUser);
                           query.findInBackground(new FindCallback<ParseObject>() {
                            public void done(List<ParseObject> users, ParseException e) {
                                if (e == null) {
                                    // iterate over all users and delete them
                                    for (ParseObject user : users) {
                                        user.deleteInBackground();
                                            Toast.makeText(getBaseContext(), "You removed" + " " + mUserFriends.get(position).getUsername().toUpperCase(), Toast.LENGTH_LONG).show();
                                            mUserFriends.remove(position);
                                            mFriendAdapter.notifyDataSetChanged();
                                        }
                                    } else {
                                        //Handle condition here
                                        Toast.makeText(getBaseContext(), "Couldn't remove" + " " + mUserFriends.get(position).getUsername().toUpperCase() + ", try again." + e.toString(), Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }

                        @Override
                        public void onNegative(MaterialDialog dialog) {
                        }
                    })
                    .show();
            return true;
        }