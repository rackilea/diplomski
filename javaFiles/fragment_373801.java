public class MyActivity extends Activity implements ScrollAwareGridView.ImmediateScrollListener, AdapterView.OnItemClickListener {

    private static final String TAG = "MyActivity";

    /** To start / pause music */
    private ImageView mSelectedImage = null;
    /** position of selected item in the adapter */
    private int mSelectedPosition;
    /** Main grid view  */
    private ScrollAwareGridView mGrid;
    /** Adapter for grid view */
    private ImageAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Show the layout with the test view
        setContentView(R.layout.main);

        mSelectedImage = (ImageView) findViewById(R.id.selectedImage);

        mGrid = (ScrollAwareGridView) findViewById(R.id.grid);

        if (null != mGrid) {
            mAdapter = new ImageAdapter(this);

            mGrid.setAdapter(mAdapter);

            mGrid.setImmediateScrollListener(this);
            mGrid.setOnItemClickListener(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        mSelectedImage.setImageBitmap(null);
        mSelectedImage.setVisibility(View.GONE);
        mSelectedPosition = -1;
    }

    @Override
    public void onImmediateScrollChanged() {
        if (mSelectedPosition >= 0) {
            int firstPosition = mGrid.getFirstVisiblePosition(); // This is the same as child #0
            int wantedChild = mSelectedPosition - firstPosition;

            // Say, first visible position is 8, you want position 10, wantedChild will now be 2
            // So that means your view is child #2 in the ViewGroup:
            if (wantedChild < 0 || wantedChild >= mGrid.getChildCount()) {
                Log.w(TAG, "Unable to get view for desired position, because it's not being displayed on screen.");
                mSelectedImage.setVisibility(View.INVISIBLE);
                return;
            } else {
                mSelectedImage.setVisibility(View.VISIBLE);
            }

            // Could also check if wantedPosition is between listView.getFirstVisiblePosition() and listView.getLastVisiblePosition() instead.
            final View selectedView = mGrid.getChildAt(wantedChild);

            if (null != selectedView && mSelectedImage.getVisibility() == View.VISIBLE) {
                // Put selected view on new position
                final ViewGroup.MarginLayoutParams zoomedImageLayoutParams = (ViewGroup.MarginLayoutParams) mSelectedImage.getLayoutParams();

                // 200 is difference between zoomed and not zoomed images dimensions
                // TODO: Avoid hardcoded values and use resources
                final Integer thumbnailX = mGrid.getLeft() + selectedView.getLeft() - (ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION - ImageAdapter.GRID_ITEM_DIMENSION) / 2;
                final Integer thumbnailY = mGrid.getTop() + selectedView.getTop() - (ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION - ImageAdapter.GRID_ITEM_DIMENSION) / 2;

                zoomedImageLayoutParams.setMargins(thumbnailX,
                        thumbnailY,
                        0,
                        0);

                mSelectedImage.setLayoutParams(zoomedImageLayoutParams);
            }
        }
    }

    @Override
    public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
        mSelectedPosition = position;

        final Bitmap bm = mAdapter.getImage(position);

        // Obtain image from adapter, with check if image presented
        if (bm != null) {
            final ViewGroup.MarginLayoutParams zoomedImageLayoutParams = (ViewGroup.MarginLayoutParams) mSelectedImage.getLayoutParams();

            // 200 is difference between zoomed and not zoomed images dimensions
            // TODO: Avoid hardcoded values and use resources
            final Integer thumbnailX = mGrid.getLeft() + view.getLeft() - (ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION - ImageAdapter.GRID_ITEM_DIMENSION) / 2;
            final Integer thumbnailY = mGrid.getTop() + view.getTop() - (ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION - ImageAdapter.GRID_ITEM_DIMENSION) / 2;

            zoomedImageLayoutParams.setMargins(thumbnailX,
                    thumbnailY,
                    0,
                    0);
            zoomedImageLayoutParams.height = ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION;
            zoomedImageLayoutParams.width = ImageAdapter.HIGHLIGHTED_GRID_ITEM_DIMENSION;

            mSelectedImage.setImageBitmap(bm);
            mSelectedImage.setScaleType(ImageView.ScaleType.CENTER);
            mSelectedImage.setLayoutParams(zoomedImageLayoutParams);
            mSelectedImage.setVisibility(View.VISIBLE);
        }
    }
}