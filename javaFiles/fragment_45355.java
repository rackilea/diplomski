@Override
public View getChildView(int listPosition, final int expandedListPosition,
                         boolean isLastChild, View convertView, ViewGroup parent) {
    final ChampText expandedListText = (ChampText) getChild(listPosition, expandedListPosition);
    if (convertView == null) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.list_item, null);
    }
    ChampText expandedListTextView = (ChampText) convertView
            .findViewById(R.id.expandedListItem);
    expandedListTextView.setText(expandedListText.getText());
    expandedListTextView.setIdveh(expandedListText.getIdveh());
    return convertView;
}