@Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if(position == 0){
            imageView.setImageResource(GalImages[position]);
            }else if(position == 1){
            new LoadImage(imageView).execute("http://www.gadgetbaazar.com/wp-content/uploads/2016/12/Top-Mobile-Phones.jpg");
            }else if(position ==2){
            new LoadImage(imageView).execute("https://pisces.bbystatic.com/BestBuy_US/store/ee/2015/com/pm/nav_desktops_1115.jpg");
            }

            container.addView(imageView, 0);
            return imageView;
        }