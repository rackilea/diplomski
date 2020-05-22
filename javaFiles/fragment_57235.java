public class AlphabeticListView extends View {

    private ListView mListView;
    private LinearLayout mSideIndex;

    private AlphabetListAdapter adapter;
    private List<Object[]> alphabet;
    private HashMap<String, Integer> sections;

    private static float sideIndexX;
    private static float sideIndexY;
    private int sideIndexHeight;
    private int indexListSize;

    private GestureDetector mGestureDetector;

    public AlphabeticListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    public AlphabeticListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public AlphabeticListView(Context context) {
        super(context);

        init();
    }

    private void init() {
        Context context = getContext();

        mGestureDetector = new GestureDetector(getContext(), 
                new SideIndexGestureListener());

        mListView = new ListView(context); // TODO add layoutParams and other attributes you might need.

        mSideIndex = new LinearLayout(context); // TODO add layoutParams and other attributes you might need.
    }

    public AlphabetListAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(AlphabetListAdapter adapter) {
        mListView.setAdapter(adapter);
        this.adapter = adapter;
    }

    public List<Object[]> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Object[]> alphabet) {
        this.alphabet = alphabet;
    }

    public HashMap<String, Integer> getSections() {
        return sections;
    }

    public void setSections(HashMap<String, Integer> sections) {
        this.sections = sections;
    }

    public void updateList() {
        mSideIndex.removeAllViews();
        indexListSize = alphabet.size();
        if (indexListSize < 1) {
            return;
        }

        int indexMaxSize = (int) Math.floor(mSideIndex.getHeight() / 20);
        int tmpIndexListSize = indexListSize;
        while (tmpIndexListSize > indexMaxSize) {
            tmpIndexListSize = tmpIndexListSize / 2;
        }
        double delta;
        if (tmpIndexListSize > 0) {
            delta = indexListSize / tmpIndexListSize;
        } else {
            delta = 1;
        }

        TextView tmpTV;
        for (double i = 1; i <= indexListSize; i = i + delta) {
            Object[] tmpIndexItem = alphabet.get((int) i - 1);
            String tmpLetter = tmpIndexItem[0].toString();

            tmpTV = new TextView(getContext());
            tmpTV.setText(tmpLetter);
            tmpTV.setGravity(Gravity.CENTER);
            tmpTV.setTextSize(15);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            tmpTV.setLayoutParams(params);
            mSideIndex.addView(tmpTV);
        }

        sideIndexHeight = mSideIndex.getHeight();

        mSideIndex.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // now you know coordinates of touch
                sideIndexX = event.getX();
                sideIndexY = event.getY();

                // and can display a proper item it country list
                displayListItem();

                return false;
            }
        });
    }

    public void displayListItem() {
        sideIndexHeight = mSideIndex.getHeight();
        // compute number of pixels for every side index item
        double pixelPerIndexItem = (double) sideIndexHeight / indexListSize;

        // compute the item index for given event position belongs to
        int itemPosition = (int) (sideIndexY / pixelPerIndexItem);

        // get the item (we can do it since we know item index)
        if (itemPosition < alphabet.size()) {
            Object[] indexItem = alphabet.get(itemPosition);
            int subitemPosition = sections.get(indexItem[0]);

            // ListView listView = (ListView) findViewById(android.R.id.list);
            mListView.setSelection(subitemPosition);
        }
    }

    class SideIndexGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, 
                float distanceY) {
            sideIndexX = sideIndexX - distanceX;
            sideIndexY = sideIndexY - distanceY;

            if (sideIndexX >= 0 && sideIndexY >= 0) {
                displayListItem();
            }

            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }
}