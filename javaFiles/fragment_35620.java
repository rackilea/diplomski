public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            convertView = inflater.inflate(R.layout.catitem, parent, false);
            TextView textView_catName = (TextView)convertView.findViewById(R.id.textView_catName);
            Category current = categories.get(groupPosition).childs.get(childPosition);
            textView_catName.setText(groupPosition + " , " + childPosition);

            if(current.childs.size() > 0 ) {
                    ExpandableListView elv = new ExpandableListView(context);
                    elv.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,  AbsListView.LayoutParams.WRAP_CONTENT));
                    elv.setAdapter(new CatAdapter(context, current.childs));
                    ((ViewGroup)convertView).addView(elv);
            }

            return convertView;
    }