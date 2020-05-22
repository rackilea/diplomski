Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
pix.setColor(Color.WHITE);
pix.fill();
Texture tex = new Texture(pix);
pix.dispose();
skin.add(tex, "white");

Drawable blackDrawable = skin.newDrawable("white", Color.BLACK);
Drawable redDrawable = skin.newDrawable("white", Color.RED);

Slider.SliderStyle sliderStyle = new Slider.SliderStyle();
sliderStyle.disabledBackground = blackDrawable;
sliderStyle.disabledKnob = redDrawable;
sliderStyle.background = blackDrawable;
sliderStyle.knob = redDrawable;