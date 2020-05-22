public class MovieAdapter extends ArrayAdapter {
    private List<CarrotModel> carrotModelList;
    private int resource;

    private LayoutInflater inflater;

    public MovieAdapter(Context context, int resource, List<CarrotModel> objects) {
        super(context, resource, objects);
        carrotModelList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {
            holder=new ViewHolder();
            convertView = inflater.inflate(resource, null);

            holder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);

            holder.tvDiscount = (TextView) convertView.findViewById(R.id.tvDiscount);
           holder.tvmername = (TextView) convertView.findViewById(R.id.tvMerName);
            holder.tvDealDesc = (TextView) convertView.findViewById(R.id.tvDealDesc);
            holder.tvOfftoDis = (TextView) convertView.findViewById(R.id.tvOftoDis);
            holder.tvmeradd = (TextView) convertView.findViewById(R.id.tvmeradd);
            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }


        final ProgressBar progressBar;


        progressBar=(ProgressBar) convertView.findViewById(R.id.progressBar);


        ImageLoader.getInstance().displayImage(carrotModelList.get(position).getImageURL(), holder.ivIcon, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.GONE);
            }
        });
        holder.tvDiscount.setText(carrotModelList.get(position).getDiscount() + "% OFF");
        holder.tvmername.setText(carrotModelList.get(position).getMerchantName());
        holder.tvDealDesc.setText(carrotModelList.get(position).getDealDescription());
        holder.tvOfftoDis.setText(carrotModelList.get(position).getOffersToDisplay());
        holder.tvmeradd.setText(carrotModelList.get(position).getMerchantAddress());

        Button Button1= (Button)  convertView.findViewById(R.id.button);

        Button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("data",holder.tvmername.getText().toString());
                startActivity(intent);
            }

        });


        return convertView;
    }

    class ViewHolder{
       private ImageView ivIcon;
        private TextView tvDiscount;
        private   TextView tvmername;
        private TextView tvDealDesc;
        private TextView tvOfftoDis;
        private  TextView tvmeradd;

    }


}