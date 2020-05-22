@Override
public Object instantiateItem(ViewGroup container, int position) {
    ImageView imgDisplay;
  //  Button btnClose;

    inflater = (LayoutInflater) _activity
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image_each, container,
            false);

    imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);

    Glide.with(container.getContext()).load(_imagePaths.get(position))
            .priority(Priority.HIGH).animate(android.R.anim.fade_in)
            .override(120, 87).fitCenter().skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.RESULT)
            .into(imgDisplay);

    ((ViewPager) container).addView(viewLayout);

    return viewLayout;
}