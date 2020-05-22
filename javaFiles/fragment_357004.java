if (convertView == null) {  // if it's not recycled, initialize some attributes


        icon = new ImageView(mContext);

        LayoutInflater inflater = (LayoutInflater)   mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.grid_icon, parent, false);

    }


    icon=(ImageView)row.findViewById(R.id.album_image);
    icon.setScaleType(ImageView.ScaleType.CENTER_CROP);

    icon.setImageResource(mThumbIds[position]);


    //overlay
    View overlay = (View) convertView.findViewById(R.id.overlay);
    int opacity = 100; // from 0 to 255
    overlay.setBackgroundColor(opacity * 0x1000000); // black with a variable alpha
    FrameLayout.LayoutParams params =
        new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT, 600);
    params.gravity = Gravity.CENTER;
    overlay.setLayoutParams(params);
    overlay.invalidate();

    return convertView;