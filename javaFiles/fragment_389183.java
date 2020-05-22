private Bitmap timestampItAndSave(Bitmap toEdit){
    Bitmap dest = Bitmap.createBitmap(toEdit.getWidth(), toEdit.getHeight(), Bitmap.Config.ARGB_8888);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateTime = sdf.format(Calendar.getInstance().getTime()); // reading local time in the system

    Canvas cs = new Canvas(dest);
    Paint tPaint = new Paint();
    tPaint.setTextSize(35);
    tPaint.setColor(Color.BLUE);
    tPaint.setStyle(Style.FILL);
    float height = tPaint.measureText("yY");
    cs.drawText(dateTime, 20f, height+15f, tPaint);
    try {
        dest.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(Environment.getExternalStorageDirectory() + "/timestamped")));
    } catch (FileNotFoundException e) {
    e.printStackTrace();
    return null;
  }
    return dest;
}