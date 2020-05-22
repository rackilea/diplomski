//create your View

    RoundedImageView yourName = new RoundedImageView();

//set LayoutParameters

    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) yourName.getLayoutParams();
            layoutParams.height = yourHeight;
            layoutParams.width = yourWidth;
    yourName.setLayoutParams(layoutParams);

//set scaleType

     yourName.setScaleType(ImageView.ScaleType.ANY_SCALE_TYPE);
//setResource
     yourName.setImageResource(R.drawable.yourDrawable);