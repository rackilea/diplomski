private class DispatchViewHolder extends BaseViewHolder {
    AppCompatTextView txtInvoiceNo;
    AppCompatTextView txtVehicleNo;
    AppCompatTextView txtPartyName;
    AppCompatTextView txtNoOfBags;
    AppCompatTextView txtMaterialType;
    AppCompatTextView txtWeight;

    DispatchViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView, itemClickListener);
    }
}


private class DispatchMaterialAdapter extends BaseRecyclerViewAdapter {

    ItemClickListener itemClickListener;
    List<? extends Object> objectArrayList;

    DispatchMaterialAdapter(ItemClickListener itemClickListener, List<? extends Object> objectArrayList) {
        super(R.layout.dispatch_material_row, itemClickListener, objectArrayList);
        this.itemClickListener = itemClickListener;
        this.objectArrayList = objectArrayList;
    }

@Override
public DispatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dispatch_material_row, parent, false);
    return new DispatchViewHolder(itemView, itemClickListener);
}
@Override
public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
    try {
        DispatchViewHolder dispatchViewHolder = (DispatchViewHolder) holder;
        DispatchMaterialMd dispatchMaterialMd = (DispatchMaterialMd) objectArrayList.get(position);
        dispatchViewHolder.txtInvoiceNo.setText(dispatchMaterialMd.getInvoiceNo());
        dispatchViewHolder.txtVehicleNo.setText(dispatchMaterialMd.getVehicleNo());
        dispatchViewHolder.txtPartyName.setText(dispatchMaterialMd.getPartyName());
        dispatchViewHolder.txtNoOfBags.setText(dispatchMaterialMd.getNoOfBags());
        dispatchViewHolder.txtMaterialType.setText(dispatchMaterialMd.getMaterialType());
        dispatchViewHolder.txtWeight.setText(dispatchMaterialMd.getWeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}