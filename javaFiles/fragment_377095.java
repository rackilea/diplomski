public class MyAdapter extends BaseAdapter {

    public View getView(int position, View convertView, ViewGroup parent) {
        // position is the element's id to use
        // convertView is either null -> create a new view for this element!
        //                or not null -> re-use this given view for element!
        // parent is the listview all the elements are in


        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.your_layout, null);

            // here you must do whatever is needed to populate the elements of your
            // list element layout
            ...
        } else {
            // re-use the given convert view

            // here you must set all the elements to the required values
        }

        // your drawable here for this element 
        convertView.setBackground( ... );

        // maybe here's more to do with the view
        return convertView;
    }
}