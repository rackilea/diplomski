case DisplayMetrics.DENSITY_HIGH:               
    display = getWindowManager().getDefaultDisplay(); 
    width = display.getWidth();
    height = display.getHeight();               

    // 0.36 is a scaling factor
    int val_high = (int) (height*0.36);

    sssImageView.setId(1);
    gaImageView.setId(2);
    spacing.setId(3);

    layoutParams = new RelativeLayout.LayoutParams(val_high, val_high);
    layoutParams2 = new RelativeLayout.LayoutParams(val_high, val_high);
    layoutParams3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, 
        (int) TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 10, this.getResources().getDisplayMetrics()));

    sssImageView.setMaxHeight(val_high);
    sssImageView.setMaxWidth(val_high);
    relativeLayout.updateViewLayout(sssImageView, layoutParams);            

    layoutParams3.addRule(RelativeLayout.BELOW, sssImageView.getId());
    relativeLayout.updateViewLayout(spacing, layoutParams3);

    layoutParams2.addRule(RelativeLayout.BELOW, spacing.getId());
    gaImageView.setMaxHeight(val_high);
    gaImageView.setMaxWidth(val_high);
    relativeLayout.updateViewLayout(gaImageView, layoutParams2);                
    break;