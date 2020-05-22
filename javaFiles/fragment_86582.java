@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    final int a=position;


    final FileHolder holder;
    View row = convertView;
    if(row==null)
    {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(textViewResourceId, parent, false);
        holder=new FileHolder();

        holder.file=files.get(position);
        holder.deleteButton=(ImageButton) row.findViewById(R.id.deleteButton);
        holder.downloadButton=(ImageButton) row.findViewById(R.id.downloadButton);

        holder.deleteButton.setTag(holder.file);
        holder.downloadButton.setTag(holder.file);


        holder.fileName= (TextView) row.findViewById(R.id.fileName);



        holder.fileName.setText(holder.file.getFileName());

    }
    else
    {
        holder=(FileHolder) row.getTag();
    }

    final AsyncCall call=new AsyncCall();

    holder.downloadButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            MODE=0;
            //call.execute(MODE);

        }
    });

    holder.deleteButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Toast.makeText(getContext(), "Delete File "+(String.valueOf(a))+"  "+holder.fileName, Toast.LENGTH_LONG).show();
            MODE=1;
            //call.execute(MODE);

        }
    });


    return row;
}