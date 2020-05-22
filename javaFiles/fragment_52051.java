mPager.setOnPageChangeListener(new OnPageChangeListener() {

                    @Override
                    public void onPageSelected(int pos) {

                            String playlist1 = stringArray[pos];
                            new GetYouTubeUserVideosTask(responseHandler, playlist1)
                            .execute();

                    }

                    @Override
                    public void onPageScrolled(int arg0, float arg1, int arg2) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int pos) {

                    }
            });