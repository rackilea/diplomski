@Override
public View getView(int position, View convertView, ViewGroup parent){      
    View v = super.getView(position, convertView, parent);
    MissionData mission = list_missions.get(position);

    if(position==4){        
        v.setBackgroundResource(R.drawable.background_list_mauve);     
    }
    return v;
}