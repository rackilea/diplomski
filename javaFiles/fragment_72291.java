public class EfficientAdapter extends BaseAdapter { 

        private Activity activity;
        private ArrayList<HashMap<String, String>> data;
        private  LayoutInflater inflater=null;
        public ImageLoader imageLoader; 
        String priceprd ;

        public EfficientAdapter (Activity a, ArrayList<HashMap<String, String>> d) {
            activity = a;
            data=d;
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            imageLoader=new ImageLoader(activity.getApplicationContext());
        }

        public EfficientAdapter(Runnable runnable,
                ArrayList<HashMap<String, String>> list_kategori) {
            // TODO Auto-generated constructor stub
        }

        public int getCount() {
            //Log.d("country",String.valueOf(data.size()));
            return data.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_checkbox, parent,
                        false);
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.TextView01);
                holder.text2 = (TextView) convertView.findViewById(R.id.TextView02);
                holder.txt = (EditText) convertView.findViewById(R.id.txtbox);
                holder.cbox = (CheckBox) convertView.findViewById(R.id.chkbox1);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            } 
            holder.text.setText( data.get(position).get("idprd"));
            holder.text2.setText(data.get(position).get("namepd"));
            holder.txt.setText("");
            holder.cbox.setChecked(false); 
            return convertView;
        }

        public class ViewHolder {
            TextView text;
            TextView text2;
            EditText txt;
            CheckBox cbox;
        }
    }


public String[] convert(List<String[]> list1) {
        // TODO Auto-generated method stub
        return null;
    }