image.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    y1 = event.getY();
                    t1 = System.currentTimeMillis();
                    return true;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    y2 = event.getY();
                    t2 = System.currentTimeMillis();

                    if (x1 == x2 && y1 == y2 && (t2 - t1) < CLICK_DURATION) {
                        Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
                    } else if ((t2 - t1) >= CLICK_DURATION) {
                        Toast.makeText(getActivity(), "Long click", Toast.LENGTH_SHORT).show();
                    } else if (x1 > x2) {
                        Toast.makeText(getActivity(), "Left swipe", Toast.LENGTH_SHORT).show();
                    } else if (x2 > x1) {
                        Toast.makeText(getActivity(), "Right swipe", Toast.LENGTH_SHORT).show();
                    } 


                    return true;
            }

            return false;
        }