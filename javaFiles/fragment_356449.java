class CustomAdapter extends ArrayAdapter<String>
    {

        Context context;
        ImageLoader imageLoader = null;

        public CustomAdapter(Context context)
        {
            super(context,0);
            this.context=context;
            sectionIndices=getSectionIndices();
            sectionDates=getSectionDates();
            imageLoader =ImageLoader.getInstance();
            options = new DisplayImageOptions.Builder()
                    .considerExifParams(true)
                    .showImageOnFail(R.drawable.profile)
                    .cacheInMemory(true)
                    .cacheOnDisc(true)
                    .considerExifParams(true)
                    .showImageForEmptyUri(R.drawable.profile)
                    .showImageOnLoading(R.drawable.profile)
                    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                    .displayer(new RoundedBitmapDisplayer(200)).build();
        }

        @Override
        public int getCount() {
            int size=0;
            try
            {
                size=db1.size();

            }
            catch(NullPointerException e)
            {

            }
            return size;
        }



        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= LayoutInflater.from(context);
            if(convertView==null)
            {
                convertView=inflater.inflate(R.layout.main_log_screen, null);
            }
            final TextView tv= (TextView)convertView.findViewById(R.id.textView1);
            TextView tv2=(TextView)convertView.findViewById(R.id.textView2);
            ImageView pic=(ImageView)convertView.findViewById(R.id.imageView1);



            RelativeLayout rel=(RelativeLayout)convertView.findViewById(R.id.relativeLayout1);


            String name=getContact(db1.get(position).phone);
            if(name!=null)
            {
                tv.setText(name);
            }
            else
            {
                tv.setText(db1.get(position).phone);
            }


            if(photoUri.get(position)!=null)
            {
                imageLoader.displayImage(photoUri.get(position), pic,options);
            }
            else
            {
                imageLoader.displayImage("drawable://" +R.drawable.profile, pic, options);
            }



            return convertView;
        }





    }