public class CustomView extends RelativeLayout{

    public CustomView(Context context, Uri imageUri, String tbnName, String tbnDescripton, String tbnDesc) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.your_layout_resource, this, true);

        ImageView tbnImage = (ImageView) findViewById(R.id.tbnImage);
        TextView tbnName = (TextView) findViewById(R.id.tbnName);
        TextView tbnExt = (TextView) findViewById(R.id.tbnExt);
        TextView tbnDesc = (TextView) findViewById(R.id.tbnDesc);

        tbnImage.setImageURI(imageUri);
        tbnName.setText(tbnName);
        tbnImage.setText(tbnDescription);
        tbnExt.setText(tbnDesc);
    }
}