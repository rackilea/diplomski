@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
    setContentView(R.layout.matching);

    //create list variable
    mUsers = new List<ParseUser>(); 
}


@Override
protected void onResume() {

    ...

    ParseQuery<ParseUser> query = ParseUser.getQuery();
    query.findInBackground(new FindCallback<ParseUser>() 
    {

        public void done(List<ParseUser> users, ParseException e) 
        {
            if (e == null) 
            {
                //add all the users to your list variable 
                mUsers.addAll(users); 

                //check the size of your list to see how big it is before accessing it
                final int size = mUsers.size(); 

                //or use a loop to loop through each one
                for(ParseUser mParseUser : mUsers)
                {
                    //skip over the current user
                    if(mParseUser == ParseUser.getCurrentUser())
                           continue; 

                    //use the correct type when getting
                     final String mName = user.getString("name");
                     final int mNumber = user.getNumber("age"); 
                     final String mHeadLine = user.getString("headline");
                 }


            } 

           else 
           {
                // Something went wrong.
           }

        }

    });
}