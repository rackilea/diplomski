@Override
public void onClick(View v) {

    switch (v.getId())
    {
        case R.id.badge1:
            badge.setImageResource(R.drawable.badge1);
            tophone = R.drawable.badge1;
            break;
        case R.id.badge2:
            badge.setImageResource(R.drawable.badge2);
            tophone = R.drawable.badge2;
            break;
        case R.id.badge3:
            badge.setImageResource(R.drawable.badge3);
            tophone = R.drawable.badge3;
            break;
        case R.id.badge4:
            badge.setImageResource(R.drawable.badge4);
            tophone = R.drawable.badge4;
            break;
        case R.id.badge5:
            badge.setImageResource(R.drawable.badge5);
            tophone = R.drawable.badge5;
            break;
        case R.id.badgebtn:
            InputStream yea = getResources().openRawResource(tophone);
            Bitmap whatever = BitmapFactory.decodeStream(yea);

            try {
                getApplicationContext().setWallpaper(whatever);
            }catch (IOException e){
                e.printStackTrace();


            }
            break;

        default:
    }