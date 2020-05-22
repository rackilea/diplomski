public void onCrossClick(View v) {

    final int position = listView.getPositionForView((View) v.getParent());
    Toast.makeText(this, "click on button " + position, Toast.LENGTH_LONG)
            .show();        
}