ItemDetailsWrapper wrapper = new ItemDetailsWrapper(list);
Intent i = new Intent(<context>, <targetActivity>);
i.putExtra("obj", wrapper); // i.putExtra("obj", new ItemDetailsWrapper(list));
// retrieving 
ItemDetailsWrapper wrap = 
                    (ItemDetailsWrapper) getIntent().getSerializableExtra("obj");
ArrayList<ItemDetails> list = wrap.getItemDetails();