@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;


        switch(position){
            case 0:{
                view = inflater.inflate(R.layout.first_list_item, parent, false);
            }break;
            case 1:{
                view = inflater.inflate(R.layout.second_list_item, parent, false);
            }break;
            case 2:{
                view = inflater.inflate(R.layout.third_list_item, parent, false);
            }break;
            default:{
                view = inflater.inflate(R.layout.general_list_item, parent, false);
            }
        }
        return view;
    }