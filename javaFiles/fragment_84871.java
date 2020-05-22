mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        imageView.setVisibility(View.INVISIBLE);
                        break;
                    default:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });