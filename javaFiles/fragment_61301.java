public static class ViewHolder{

        public TextView text;

        public ImageView image;

    }



    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;

        ViewHolder holder;

        if(convertView==null){

            vi = inflater.inflate(R.layout.item, null);

            holder=new ViewHolder();

            holder.text=(TextView)vi.findViewById(R.id.text);;

            holder.image=(ImageView)vi.findViewById(R.id.image);

            vi.setTag(holder);

        }

        else

            holder=(ViewHolder)vi.getTag();



        holder.text.setText("item "+position);

        holder.image.setTag(data[position]);

        imageLoader.DisplayImage(data[position], activity, holder.image);

        return vi;

    }