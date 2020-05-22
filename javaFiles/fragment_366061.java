private class JokeListAdapter extends BaseAdapter {
    List<Joke> mJokes = new ArrayList<Joke>(); // use this list for every ever in adapter
    public JokeListAdapter() {

    }
    public void setValue(List<Joke> jokes) {
        mJokes.clear(); // Clearing old items(To add new items only)
        if(jokes != null && jokes.size() > 0) { // We dont need to add if the size is 0
             mJokes.addAll(jokes); // Adding all the item to the list item
        }
        notifyDataSetChanged(); // We are refreshing View the latest with list items.
    }

    @Override
    public int getCount() {
       return mJokes.size();
    }