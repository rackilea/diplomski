ImageView life1 = new ImageView(context);
    life1.setImageResource(R.mipmap.heart);
    ImageView life2 = new ImageView(context);
    life1.setImageResource(R.mipmap.heart); //Should be life2
    ImageView life3 = new ImageView(context);
    life1.setImageResource(R.mipmap.heart);//Should be life3
    ImageView life4 = new ImageView(context);
    life1.setImageResource(R.mipmap.heart);//Should be life4
    ImageView life5 = new ImageView(context);
    life1.setImageResource(R.mipmap.heart);//Should be life5