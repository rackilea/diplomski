AD = new SimpleAdapter(this, data, R.layout.modelo, from, views){
@Override
public View getView(int position, View convertView, ViewGroup parent) {
View v = convertView;
if (v == null) {
LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
v = vi.inflate(R.layout.modelo, null);
}
TextView text1 = (TextView) v.findViewById(R.id.txttitulo);
TextView text2 = (TextView) v.findViewById(R.id.txtconteudo);
TextView text3 = (TextView) v.findViewById(R.id.textview3);
text1.setTextColor(Color.GREEN);
text2.setTextColor(Color.GREEN);
text3.setTextColor(Color.GREEN);
return super.getView(position, v, parent);
}
};