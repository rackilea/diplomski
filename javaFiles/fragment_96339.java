ImageView[] candies = new ImageView[10];
 for(int i=0;i<candies.length;i++){
      candies[i]=new ImageView(this);
      // TODO: Set LayoutParams for each imageView
      // i.e. AbsoluteLayout.LayoutParams imageParams1 = new AbsoluteLayout.LayoutParams(imageWidth, imageHeight); 

     candies[i].setBackgroundResource(R.drawable.candy); 
     layout.addView(candies[i], imageParams1);
}