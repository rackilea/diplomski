@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(mCtx);
    // View view = inflater.inflate(R.layout.list_publikasi,null,true);
    if(converView == null) {
         convertView = inflater.inflate(R.layout.item_user, parent, false);
    }

    TextView textNama = (TextView) convertView.findViewById(R.id.textNama);
    TextView textDetail = (TextView) convertView.findViewById(R.id.textDetail);
    TextView textStatus = (TextView) convertView.findViewById(R.id.textStatus);
    TextView textPeriode = (TextView) convertView.findViewById(R.id.textPeriode);

    Publikasi publikasi = lstPublikasi.get(position);
    textNama.setText(publikasi.namaJurnal);
    textDetail.setText(publikasi.tipePublikasi);
    textStatus.setText(publikasi.status);
    textPeriode.setText(publikasi.periode);

    return convertView;
}