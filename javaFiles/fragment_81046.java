private int counter = 0;
  @Override
  public void onGlobalLayout() {
    // TODO Auto-generated method stub

    /* Width and height on this time are known */

    int width  = mGridLayout.getWidth();
    int height = mGridLayout.getHeight();

    /* Buttons width and height are supposed to be */

    int mButtons_width  = width;
    int mButtons_height = height / 2;

    if(!(mButtonAbove.getWidth()  == mButtons_width  &&
         mButtonAbove.getHeight() == mButtons_height &&
         mButtonBelow.getWidth()  == mButtons_width  &&
         mButtonBelow.getHeight() == mButtons_height)
      ){

      /* Changes the LayoutParams of ContentViews children dynamicly */

      mGridLayout_LayoutParams_Above.width = mButtons_width;
      mGridLayout_LayoutParams_Above.height = mButtons_height;

      mGridLayout_LayoutParams_Below.width = mButtons_width;
      mGridLayout_LayoutParams_Below.height = mButtons_height;

      /* NO ISSUE ANYMORE:
       * updates the rendering of the buttons */

      mButtonAbove.requestLayout();
      mButtonBelow.requestLayout();

    }

    /* A little debug info for knowing the ContentView's and Children's size */

    mButtonBelow.setText("Own Width = " + mButtonBelow.getWidth() + "\n" + 
                         "Own Height = " + mButtonBelow.getHeight() + "\n" +
                         "Perents Width = " + width + "\n" +
                         "Perents Height = " + height + "\n" +
                         "Calls = " + counter++);

  }