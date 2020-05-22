mPager.setOnPageChangeListener(new OnPageChangeListener() {

        @Override
        public void onPageSelected(int pos) {

            switch (pos) {
        case 0: Toast.makeText(Home.this, "Case 0", Toast.LENGTH_LONG).show();
            break;

        case 1:  Toast.makeText(Home.this, "Case 1", Toast.LENGTH_LONG).show();
            break;

        case 2:  Toast.makeText(Home.this, "Case 2", Toast.LENGTH_LONG).show();
            break;

        case 3:  Toast.makeText(Home.this, "Case 3", Toast.LENGTH_LONG).show();
            break;

        }
            String playlist1 = stringArray[pos];
            if (playlist != null) {
                new GetYouTubeUserVideosTask(responseHandler, playlist1)
                        .execute();

            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int pos) {

        }
    });