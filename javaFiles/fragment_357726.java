new Thread(new Runnable() {
                    public void run() {
                        int frameIndex = 0;
                        mRun = true;
                        while (mRun) {
                            ++frameIndex;
                            SystemClock.sleep(100);
                            BitmapDrawable frame = (BitmapDrawable) yinyangAnimation.getFrame(frameIndex);
                            noti.contentView.setImageViewBitmap(R.id.status_icon, frame.getBitmap());
                            nm.notify(STATUS_BAR_NOTIFICATION, noti);
                            if (frameIndex >= yinyangAnimation.getNumberOfFrames()-1) {
                                frameIndex = 0;
                            }
                        }

                    }
                  }).start();