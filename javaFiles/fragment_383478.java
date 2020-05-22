@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            default:
                Movie review = movieArrayAdapter.getItem(position);
                Intent nextActivity = new Intent(MainActivity.this, ShortReview.class);
                nextActivity.putExtra("summary", review.getsummary());
                startActivity(nextActivity);
                break;
        }
    }
});