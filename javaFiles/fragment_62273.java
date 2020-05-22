@Override
        public boolean onTouchEvent(MotionEvent motionEvent) {

            switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    // Player has touched the screen
                case MotionEvent.ACTION_DOWN:

                    System.out.println("Hallo");

                    break;

                    // Player has removed finger from screen
                case MotionEvent.ACTION_UP:

                    break;
            }
            return true;
        }