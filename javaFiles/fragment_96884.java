private GestureDetectorCompat gestureDetector;

    // in your adapter constructor
    gestureDetector = new GestureDetector(context, new SingleTapConfirm());

    public View getView(final int position, View recycled, ViewGroup parent) {

        ViewHolder holder;
        if (recycled == null) {
            .....find items by id
        } else {
            holder = (ViewHolder) recycled.getTag();
        }

        // Set listener to item image
        holder.image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Use lazy initialization for the gestureDetector
                gestureDetector.onTouchEvent(event);
                // At least the onTouch-callback gets called with the correct position
                return true;
            }
        });

        // Use glide library to load images into the image views
        Glide.with(mContext)....into(holder.image);
        return recycled;
    }

    private class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            Log.e(TAG, "onSingleTapConfirmed"); // never called..
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.e(TAG, "onDoubleTap"); // never called..
            return super.onDoubleTap(e);
        }
    }