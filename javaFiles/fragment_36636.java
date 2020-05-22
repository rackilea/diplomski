nifty.loadStyleFile("nifty-default-styles.xml");
nifty.loadControlFile("nifty-default-controls.xml");

new ScreenBuilder("start") {{
  layer(new LayerBuilder("background") {{
    backgroundColor("#f008");
    childLayoutAbsolute();
    control(new ButtonBuilder("showPopupButton", "SHOW") {{
      x(SizeValue.px(100));
      y(SizeValue.px(100));
      interactOnClick("showPopup()");
    }});
  }});
}}.build(nifty);
nifty.gotoScreen("start");