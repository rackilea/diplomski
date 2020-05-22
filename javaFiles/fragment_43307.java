viewHolder.checkParentView.setTag(itemsData.get(position));
viewHolder.checkParentView.setOnClickListener(checkedListener);

    private View.OnClickListener checkedListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        CheckListSource childListResponse = (CheckListSource ) v.getTag();
        if (childListResponse.isSelected())
            childListResponse.setSelected(false);
        else
            childListResponse.setSelected(true);
        notifyDataSetChanged();
    }
};