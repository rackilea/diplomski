public void populateMemberDetailsScreen(String _name, String _birthday, String _gender, 
    String _twitterId, String _numCommittees, String _numRoles) {

    TextView tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_name);
    tv.setText(_name);

    tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_birthday);
    tv.setText(_birthday);

    tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_gender);
    tv.setText(_gender);

    tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_twitter_id);
    tv.setText(_twitterId);

    tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_num_committees);
    tv.setText(_numCommittees);

    tv = (TextView) mMemberDetailsScreen.findViewById(R.id.text_num_roles);
    tv.setText(_numRoles);
}