protected void setupUIElements(Activity activity) //
{

    listView = (ListView) activity.findViewById(R.id.CatalogProducts);

    m_adapter = new CatalogItemAdapter(activity,
            R.layout.catalog_item_stub, products, activity);

    listView.setAdapter(m_adapter);
}