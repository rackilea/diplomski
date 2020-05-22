public class ExampleFragment extends Fragment {

    private ImageView mImageView;

    private final ExampleTask.Listener mListener = new ExampleTask.Listener() {

        @Override
        public void onResult(Bitmap image) {
            mImageView.setImageBitmap(image);   
        }
    };

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new ExampleTask(mListener).execute(); 
    }

    ...
}