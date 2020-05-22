public class CustomHorizontalSwip extends PagerAdapter {

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.custom_swipe_dieren,container,false);
        ImageView imageView=(ImageView) itemView.findViewById(R.id.swip_image_view);
        imageView.setImageResource(imageResources[position]);
        imageView.setOnLongClickListener(longClickListener);
        container.addView(itemView);
        return itemView;
    }

    /* Declare and Initialise longClickListener in this file also */

    /* Also do same for dragListener in this file */

}