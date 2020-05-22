@Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
//     >>>    >>>                 ^^^^^^  This is your posotion = index

        View row = convertView;
        Your_Holder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resId, parent, false);
            holder = new Your_Holder();

            ....
            ....
            holder.yourImageView = (ImageView) row.findViewById(R.id.yourImageID);
            ....
            ....

            row.setTag(holder);
        }
        else{
            holder = (Your_Holder)row.getTag();
        }

   //    Set here your images click event
        holder.yourImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("Position = " + position)

            }
        });

    }