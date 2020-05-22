private void addOnClickListener(Button button, myFragment) {
    button.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {

            // Pass the id of view to fragment
            Bundle data = new Bundle();
            data.putInt("id", v.getId());
            myFragment.setArgument(data);

            myFragment.show(fm, "theFragment");
            return false;
    }
});