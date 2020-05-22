protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ImageView checkImage = (ImageView)view.findViewById(R.id.check_grid_image

        if (mGridView.isItemChecked(position)) {
            // Action when Item checked
            checkImage.setVisibility(View.VISIBLE);
        }
        else {
            // Reverse Action
            checkImage.setVisibility(View.INVISIBLE);
        }
    }
};