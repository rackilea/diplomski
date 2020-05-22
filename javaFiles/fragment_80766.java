private void InitilizeGridLayout() {
            Resources r = getResources();
            float padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    GRID_PADDING, r.getDisplayMetrics());

            columnWidth = (int) (((getScreenWidth()) - ((NUM_OF_COLUMNS + 1) * padding)) / NUM_OF_COLUMNS);

            gridView.setNumColumns(NUM_OF_COLUMNS);
            gridView.setColumnWidth(columnWidth);
            gridView.setStretchMode(GridView.NO_STRETCH);
            gridView.setPadding((int) padding, (int) padding, (int) padding,(int) padding);
            gridView.setHorizontalSpacing((int) padding);
            gridView.setVerticalSpacing((int) padding);
        }
        @SuppressLint("NewApi")
        public int getScreenWidth() {
            int columnWidth ;
            WindowManager wm = (WindowManager) this
                    .getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();

            final Point point = new Point();
            try {
                display.getSize(point);
            } catch (java.lang.NoSuchMethodError ignore) { // Older device
                point.x = display.getWidth();
                point.y = display.getHeight();
            }                              
            columnWidth = point.x;
            return columnWidth;
        }