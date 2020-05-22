@Override
public View getView(int position, View convertView, ViewGroup parent) {
    Model model = models.get(position);
    ViewHolder holder = null;
    if(convertView ==null){
        holder = new ViewHolder();
        convertView = View.inflate(context, R.layout.list_view,null);
        holder.code = convertView.findViewById(R.id.cardcode);
        holder.title = convertView.findViewById(R.id.cardTitle);
        converView.setTag(holder);    
    }else{
        holder = (ViewHolder)converView.getTag();
    }
    holder.code.setText(model.getAuditcode());
    holder.title.setText(model.getSystemAudit());

    return convertView;
}