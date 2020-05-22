class VivzAdapter extends ArrayAdapter<String> implements OnCheckedChangeListener {
Context context;
int[] images;
String[] titlesArray, descrptionArray;
List<Integer> positions = new ArrayList<Integer>();

ArrayList<Boolean> arrChecked;

VivzAdapter(Context context, String[] titles, int[] images, String[] description) {

super(context, R.layout.single_row, R.id.textView1, titles);
this.context = context;
this.images = images;
this.titlesArray = titles;
this.descrptionArray = description;

// initialize arrChecked boolean array and add checkbox value as false initially for each item of listview
arrChecked = new ArrayList<Boolean>();
for (int i = 0; i < titles.size(); i++) {
arrChecked.add(false);
}
}

class MyViewHolder {
ImageView myImage;
TextView myTitle;
TextView myDescription;
CheckBox box;

MyViewHolder(View v) {
    myImage = (ImageView) v.findViewById(R.id.imageView1);
    myTitle = (TextView) v.findViewById(R.id.textView1);
    myDescription = (TextView) v.findViewById(R.id.textView2);
    box = (CheckBox) v.findViewById(R.id.checkBox1);
}
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
View row = convertView;
MyViewHolder holder = null;
if (row == null) {
    // 1.ºtime
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    //row contem RelativeLayout(root) em single_row.xml
    row = inflater.inflate(R.layout.single_row, parent, false);
    holder = new MyViewHolder(row);
    row.setTag(holder);
    //Log.d("VIVZ", "Creating a new Row");
} else {
    //reciclamos aqui, qeremos usar antigo objecto holder
    holder = (MyViewHolder) row.getTag();
    //Log.d("VIVZ", "Recycling stuff");
}
holder.myImage.setImageResource(images[position]);
holder.myTitle.setText(titlesArray[position]);
holder.myDescription.setText(descrptionArray[position]);

//set position as id
holder.box.setId(position);
//set onClickListener of checkbox rather than onCheckedChangeListener
holder.box.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            int id = v.getId();

            if (arrChecked.get(id)) {
                //if checked, make it unchecked
                arrChecked.set(id, false);
            } else {
                //if unchecked, make it checked
                arrChecked.set(id, true);

            }

        }
    });

    //set the value of each checkbox from arrChecked boolean array
    holder.box.setChecked(arrChecked.get(position));

return row;
}
}