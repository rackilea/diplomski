@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ...Code to get the view holder...

    holder.imgscrollchild.removeAllViews();
    for(int i=0; i<numOfImageViews;i++) {

        holder.imgscrollchild.addView(createimg(tempValues.getImage(), tempValues.getText()));
    }

    return horizontalLayout;
}