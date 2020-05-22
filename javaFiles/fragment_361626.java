public CustomRecyclerView(Context context, AttributeSet attrs) {
            super(context, attrs);

            if (LayoutManager.getProperties(context, attrs, 0, 0).orientation == 0)
                Log.d("recycler orientation", "horizontal");
            else if (LayoutManager.getProperties(context, attrs, 0, 0).orientation == 1)
                Log.d("recycler orientation", "vertical");
     }