AssetManager assetManager = getContext().getAssets();       

Typeface tf = Typeface.createFromAsset(assetManager,"GILB.TTF");                

TextView logo = (TextView)findViewById(R.id.logo);
logo.setTypeface(tf);