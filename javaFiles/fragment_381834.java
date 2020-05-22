public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewHolder viewHolder = new viewHolder();

            if(view == null){
                view = inflater.inflate(R.layout.list,null);
                viewHolder.name = (TextView) view.findViewById(R.id.listTitle);
                viewHolder.image = (ImageView) view.findViewById(R.id.listImage);
                view.setTag(viewHolder);
            }else viewHolder = (viewHolder) view.getTag();

            if (list.size() > 0){
                MainList mainList = list.get(i);
                viewHolder.name.setText(mainList.getName());
            }
        }catch (Exception e){
            Log.i("Tag:LM", "getView: " + e.toString());
        }


        return view;
    }