pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int pos) {
          //This is because progress is 0 at the start of the program
          progress++;
          ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar);
                progress.setProgress(position++);
        }

    });