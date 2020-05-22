public class TuMesaAdapter extends ArrayAdapter<TuMesaModel>{
private String _id;
public TuMesaAdapter(Context context, List<TuMesaModel> objects, String id) {
    super(context, 0, objects);
    _id = id;
}
@Override
public View getView(final int position, View convertView, ViewGroup parent){
    ViewHolder holder = null;
    TuMesaModel entry = getItem(position);
    String numero = "+"+entry.getUsername();
    //Toast.makeText(getContext(), Settings.PREFERENCES.getString(Settings.PHONE_PREF, null), Toast.LENGTH_LONG).show();
    if(convertView == null){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if(!entry.isAdmin()){
            convertView = inflater.inflate(R.layout.tumesa_user, parent, false);
            holder = new ViewHolder();
            holder.numero_personal_tu_mesa = (TextView) convertView.findViewById(R.id.numero_personal_tu_mesa);
            holder.aceptar_y_rechazar_tu_mesa = (LinearLayout) convertView.findViewById(R.id.aceptar_y_rechazar_tu_mesa);
            holder.foto_perfil_tu_mesa = (ImageView) convertView.findViewById(R.id.foto_perfil_tu_mesa);
            holder.mRelative = convertView.findViewById(R.id.layout_tu_mesa);
            holder.mRechazarTuMesa = convertView.findViewById(R.id.rechazar_tu_mesa);
            holder.mRechazarTuMesa.setOnClickListener(new View.OnClickListener(){
               @Override  
               public void onClick(View v){
                // do what you need to do here;
               };


};
            Utils.setFontAllView((ViewGroup) holder.mRelative);
            convertView.setTag(holder);
        }else{
            convertView = inflater.inflate(R.layout.null_item, parent, false);
            holder = new ViewHolder();
            convertView.setTag(holder);
        }
    }else{
        holder =  (ViewHolder) convertView.getTag();
    }
    holder.numero_personal_tu_mesa.setText(entry.getUsername()); 
    return convertView;
}
private static class ViewHolder {
    public View mRelative;
    public TextView numero_personal_tu_mesa;
    public LinearLayout aceptar_y_rechazar_tu_mesa;
    public ImageView foto_perfil_tu_mesa;
    public ImageView mRechazarTuMesa;   
}}