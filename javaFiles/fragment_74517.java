public class CustomAdapter extends BaseAdapter {

public  static  String counter="";
public static int result=0;
Context context;
private int layoutResourceId;
private ArrayList<ImageItemBin> data=new ArrayList<ImageItemBin>();
public static  ImageItemBin showBin=new ImageItemBin();
DataTransferInterfase dataTransferInterfase;

String qty,title;
public MainActivity mainActivity;
ImageLoader imageLoader;
DisplayImageOptions options;

private static LayoutInflater inflater=null;
public CustomAdapter(MainActivity mainActivity,ArrayList<ImageItemBin> data,DataTransferInterfase dataTransferInterfase){

    this.data=data;
    this.context=mainActivity;
    this.dataTransferInterfase=dataTransferInterfase;

    this.mainActivity=mainActivity;
    inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}



@Override
public int getCount() {
    return data.size();
}

@Override
public Object getItem(int position) {
    return data.get(position);
}

@Override
public long getItemId(int position) {
    return 0;
}

public View getView(final int position, final View convertView, ViewGroup parent) {
    Holder holder=null;
    View rootview=convertView;

    if(rootview==null) {

        rootview = inflater.inflate(R.layout.custom_grid_item_layout, null);
        holder = new Holder();
        holder.edttitle = (EditText) rootview.findViewById(R.id.edtTitle);
        holder.edtqty = (EditText) rootview.findViewById(R.id.edtQty);
        holder.image = (ImageView) rootview.findViewById(R.id.MyimageView);
        holder.tvcounter=(TextView)rootview.findViewById(R.id.tvcounter);

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        rootview.setTag(holder);

        qty=holder.edtqty.getText().toString();
        title=holder.edttitle.getText().toString();
        data.get(position).setTitle(title);
        data.get(position).setQty(qty);




    }
    else
    {
        holder=(Holder)convertView.getTag();
        holder.image.setTag(position);
        holder.edttitle.setTag(position);
        holder.edtqty.setTag(position);


        qty=holder.edtqty.getText().toString();
        title=holder.edttitle.getText().toString();
        data.get(position).setTitle(title);
        data.get(position).setQty(qty);



    }

    String img=data.get(position).getImage();
    final String title=data.get(position).getTitle();
    final String qty=data.get(position).getQty();

    options = getDisplayImageOptions(context, R.mipmap.ic_launcher);
    imageLoader.displayImage(img, holder.image, options);


    holder.btnadd=(Button)rootview.findViewById(R.id.btnAdd);
    final Holder finalHolder = holder;
    //public static final ImageItemBin showBin=new ImageItemBin();
    holder.btnadd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            data.get(position).setQty(qty);
            data.get(position).setTitle(title);
            showBin.setImage(data.get(position).getImage());
            showBin.setTitle(title);
            showBin.setQty(qty);
            mainActivity.CountRecord(data.get(position));

        }
    });

    return rootview;
}

 static class Holder{
    ImageView image;
    EditText edtqty;
    EditText edttitle;
     Button btnadd;
     TextView tvcounter;
}

public static DisplayImageOptions getDisplayImageOptions(Context context, int defaultImg) {
    DisplayImageOptions options = new DisplayImageOptions.Builder().showImageOnLoading(defaultImg)
            .resetViewBeforeLoading(true).showImageForEmptyUri(defaultImg).showImageOnFail(defaultImg)
            .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565)
            .considerExifParams(true).build();

    return options;
}