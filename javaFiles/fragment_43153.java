@Override
 public void onClick(View v) {
     LinearLayout view = (LinearLayout) findViewById(R.id.layout1);
     view.setBackgroundResource(images[imagesIndex]); 
     ++imagesIndex;  // update index, so that next time it points to next resource
     if (imagesIndex == images.length - 1)
         imagesIndex = 0; // if we have reached at last index of array, simply restart from beginning.
  }