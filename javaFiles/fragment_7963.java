ItemClickedCallback callback;
public AdapterGetAddress(Context context, List<ModelGetAddress> modelGetAddressList, ItemClickedCallback callback) {
    this.context = context;
    this.modelGetAddressList = modelGetAddressList;
    this.callback= callback;
}