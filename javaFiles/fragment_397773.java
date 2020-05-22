public class CatalogItemAdapter extends ArrayAdapter<Product> //
{
private ArrayList<Product> products;
private Activity activity;

public CatalogItemAdapter(Context context, int textViewResourceId,
        ArrayList<Product> items, Activity activity) //
{
    super(context, textViewResourceId, items);
    this.products = items;
    this.activity = activity;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) //
{
    Product product = products.get(position);

    if (convertView == null) //
    {
        LayoutInflater vi = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = vi.inflate(R.layout.catalog_item_stub, null, false);
            //this is the layout resource for each item
    }

    TextView priceView = (TextView) convertView
            .findViewById(R.id.ProductPrice);
    TextView titleView = (TextView) convertView
            .findViewById(R.id.ProductTitle);

    priceView.setText(price);
    titleView.setText(product.DisplayName);

    return convertView;
}
}