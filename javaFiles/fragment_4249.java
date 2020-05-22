public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {


ArrayList<Bitmap>  images= new ArrayList<Bitmap>();


public RvAdapter(Context context){

    images.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.explorepakistan));
    images.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.tracking));
    images.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.international));
    images.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bikerides));


}

@Override
public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.home_card_view, parent ,false);



    return new ViewHolder(view);
}

@Override
public void onBindViewHolder(final RvAdapter.ViewHolder holder, final int position) {

    holder.imageView.setImageBitmap(images.get(position));
    holder.imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(position == 0)
            {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear_layout,new SentFragment()).commit();

            }else if(position == 1)
            {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear_layout,new SentFragment()).commit();

            }
        }
    });


}

@Override
public int getItemCount() {
    return images.size();
}


public class ViewHolder extends RecyclerView.ViewHolder {

   ImageView imageView;
   Context context;
    public ViewHolder(View itemView) {

    this.context = itemView.getContext();

        super(itemView);
// add your click listner here insted
itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(getPposition == 0)
            {
                FragmentTransaction fragmentTransaction = ((Your Activity Name) context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.linear_layout,new SentFragment()).commit();

            }else if(getPposition == 1)
            {
                FragmentTransaction fragmentTransaction = ((Your Activity Name) context).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.linear_layout,new SentFragment()).commit();

            }
        }
    });



    }
}