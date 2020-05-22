public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView==null)
        { 
        viewHolder = new ViewHolder();
        convertView = inflater.inflate(R.layout.row_grid, null);
        // inflate row_grid.xml  

        viewHolder.mainView= (ImageView)convertView.findViewById(R.id.item_image);
        //initialize imageview
        convertView.setTag(viewHolder);
        }else{
         viewHolder = (ViewHolderItem) convertView.getTag();

        }
        Bitmap bitmap = mReceiptList.get(position).getImage();
        if (bitmap != null)
           holder.mainView.setImageBitmap(bitmap); 
           // set bitmap to imageview

        return convertView;
    }