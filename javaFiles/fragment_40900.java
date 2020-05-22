OnButtonClickListener mCallback;
......your code
public interface OnButtonClickListener {
    void onButtonSelected(int position);
}
......your code
then you call your callback method
.....
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int   position, long l) {
            mCallback.onButtonSelected(position);
        }
    });