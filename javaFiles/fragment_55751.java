if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    long tmp = System.nanoTime() / 1000000;
                    Log.w("EVENT", "SurfaceView " + tmp); // executed doubly! funny stuff.
                    queueEvent(new Runnable()
                    {
                        @Override
                        public void run()
                        {                              
                            gameRenderer.handleTouchPress(normalizedX, normalizedY);
                        }
                    });
                }