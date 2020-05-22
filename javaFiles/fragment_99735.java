img_LeftScroll.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (horizontalLayoutManagaer.findFirstVisibleItemPosition() > 0) {
                rv_horizontal.smoothScrollToPosition(horizontalLayoutManagaer.findFirstVisibleItemPosition() - 1);
            } else {
                rv_horizontal.smoothScrollToPosition(0);
            }

        }
    });

 img_right_scroll.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rv_horizontal.smoothScrollToPosition(horizontalLayoutManagaer.findLastVisibleItemPosition() + 1);
        }
    });