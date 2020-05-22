LinearGradient test = new LinearGradient(0.f, 0.f, 300.f, 0.0f,  

      new int[] { 0xFF000000, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF,
      0xFFFF0000, 0xFFFF00FF, 0xFFFFFF00, 0xFFFFFFFF}, 
      null, TileMode.CLAMP);
ShapeDrawable shape = new ShapeDrawable(new RectShape());
shape.getPaint().setShader(test);

SeekBar seekBarFont = (SeekBar)findViewById(R.id.seekbar_font);
seekBarFont.setProgressDrawable( (Drawable)shape );