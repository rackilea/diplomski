@Override
public void onClick(View v) {
    Toast.makeText(this, v.getClass().getName() + " clicked!", Toast.LENGTH_SHORT).show();
    if (v.getId() == R.id.mTextView || v.getId() == R.id.mTopLayout) {
        //do whatever I need
    }
}