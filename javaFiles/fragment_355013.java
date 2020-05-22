public class MyAdapter extends ArrayAdapter<Person> {

    Context context;
    List<Person>myList;

    public MyAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);

        this.context = context;
        this.myList = objects;
    }


    @Override
    public int getCount() {
        if(myList != null)
            return myList.size();
        return 0;
    }

    @Override
    public Person getItem(int position) {
        if(myList != null)
            return myList.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        if(myList != null)
            return myList.get(position).hashCode();
        return 0;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;

        //If the listview does not have an xml layout ready set the layout
        if (convertView == null){

            //we need a new holder to hold the structure of the cell
            holder = new Holder();

            //get the XML inflation service
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Inflate our xml cell to the convertView
            convertView = inflater.inflate(R.layout.person_cell, null);

            //Get xml components into our holder class
            holder.txtName = (TextView)convertView.findViewById(R.id.person_cell_txtName);
            holder.txtSurname = (TextView)convertView.findViewById(R.id.person_cell_txtSurname);
            holder.imageView = (ImageView)convertView.findViewById(R.id.person_cell_imageview);

            //Attach our holder class to this particular cell
            convertView.setTag(holder);

        }else{

            //The listview cell is not empty and contains already components loaded, get the tagged holder
            holder = (Holder)convertView.getTag();

        }

        //Fill our cell with data

        //get our person object from the list we passed to the adapter
        Person person = getItem(position);

        //Fill our view components with data
        holder.txtName.setText(person.getName());
        holder.txtSurname.setText(person.getSurname());

             Picasso.with(context).load(person.getImageUrl()).fit().into(holder.imageView);

        return convertView;
    }

    /**
     * This holder must replicate the components in the person_cell.xml 
     * We have a textview for the name and the surname and an imageview for the picture
     */
    private class Holder{

        TextView txtName;
        TextView txtSurname;
        ImageView imageView;

    }
}