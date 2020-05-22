private class CustomAdapter extends ArrayAdapter<ByteDrawable>{
    public CustomAdapter(Context context, int resource, ArrayList<ByteDrawable > byteDrawableList) {
        super(context, resource, byteDrawableList);
        this.context=context;
        this.byteDrawableList= new ArrayList<ByteDrawable >();
        this.byteDrawableList.addAll(byteDrawableList);
            inflater = LayoutInflater.from(context);
            long k = 0;
            for (ByteDrawable bd : byteDrawableList) {
                String base = bd.getImageByteString();
                byte[] imageAsBytes = Base64.decode(base.getBytes(),
                        Base64.DEFAULT);

                items.add(new Item(k, BitmapFactory.decodeByteArray(
                        imageAsBytes, 0, imageAsBytes.length)));
                k++;
            }

    }
   private class Item {
        final long itmeid;
        final Bitmap drawabledata;

        Item(long id, Bitmap bitmap) {
            this.itmeid = id;
            this.drawabledata = bitmap;
        }
    }
    public View getView(final int position, View view, ViewGroup viewGroup) {
        /* follow normal way to set data to list item*/
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).itmeid;
    }
}