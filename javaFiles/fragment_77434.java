ToolTipRelativeLayout toolTipRelativeLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipRelativeLayout);

    ToolTip toolTip = new ToolTip()
                        .withText("A view")
                        .withColor(Color.RED)
                        .withShadow()
                        .withAnimationType(ToolTip.ANIMATIONTYPE_FROMTOP);
    myToolTipView = toolTipRelativeLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_redtv));
    myToolTipView.setOnToolTipViewClickedListener(MainActivity.this);