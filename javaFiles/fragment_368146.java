button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int statusbarHeight = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight()
                        - YOURVIEW.getHeight();
                int[] position = new int[2];
                vline.getLocationInWindow(position);
                scrollView.smoothScrollBy(0, (position[1]-statusbarHeight));
            }
        });