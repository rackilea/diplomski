@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.some_layout, parent, false);


        switch(position){
            case 0:{
                // change view for first position
            }break;
            case 1:{
                // change view for second position
            }break;
            case 2:{
                // change view for third position
            }break;
            default:{
                // change view for other positions
            }
        }
        return view;
    }