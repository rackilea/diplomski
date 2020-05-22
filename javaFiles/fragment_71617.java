@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) mcontext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if(convertView == null){
            gridView = new View(mcontext);

            gridView = inflater.inflate(R.layout.imageview,null);
            ImageView imageView =(ImageView)gridView.findViewById(R.id.imageView);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = false;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize = 3;
            options.inPurgeable = true;

            Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                    Imageid[position],options);


            holder.imageView.setImageBitmap(icon);
        }
            else {
                gridView = (View) convertView;
            }


        return gridView;
    }