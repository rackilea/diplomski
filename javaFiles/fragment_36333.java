public View getView(int position, View convertView, ViewGroup parent) {LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.list_item, parent, false);

View iv = rowView.findViewById(R.id.leftBar);


   if (position == ListView.currentStage){
        iv.setBackgroundColor(getContext().getResources().getColor(R.color.Green));
    } else if (position < ListView.currentStage){
        iv.setBackgroundColor(getContext().getResources().getColor(R.color.Red));
    }else if (position > ListView.currentStage) {
        iv.setBackgroundColor(getContext().getResources().getColor(R.color.Peach));
    }