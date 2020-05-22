linear1.setOnTouchListener(new View.OnTouchListener() {
                float initX;
                float initY;
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch(event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initX = event.getX();
                            initY = event.getY();
                            break;
                        case MotionEvent.ACTION_UP:
                            initX -= event.getX();
                            initY -= event.getY();
                            if (initY > len) {
                                //Logic For Swipe Right
                            } else if(initY < -len) {
                                //Logic For Swipe Left   
                            }
                            break;
                     }
                     return true;
                }
});