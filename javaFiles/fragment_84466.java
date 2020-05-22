class CustomAdapter extends BaseAdapter {

        Activity a;
        ArrayList<String> Rollno;
        ArrayList<String> Stdname;
        ArrayList<String> Stdstatus;
        HashMap<Integer, Integer> statusArray = new HashMap<>();

        public CustomAdapter(Activity a, ArrayList<String> rollno, ArrayList<String> stdname, ArrayList<String> stdstatus) {
            this.a = a;
            Rollno = rollno;
            Stdname = stdname;
            Stdstatus = stdstatus;
        }


        @Override
        public int getCount() {
            return Rollno.size();
        }

        @Override
        public Object getItem(int position) {
            return Rollno.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        public  class ViewHolder{
            TextView rollno,name;
            Button status;
        }



        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final  ViewHolder viewHolder=new ViewHolder();
            LayoutInflater li=a.getLayoutInflater();
            View v=li.inflate(R.layout.custom,parent,false);
            viewHolder.rollno=(TextView)v.findViewById(R.id.crollno);
            viewHolder.name=(TextView)v.findViewById(R.id.cname);
            viewHolder.status=(Button)v.findViewById(R.id.btn1);


            viewHolder.rollno.setText(Rollno.get(position));
            viewHolder.name.setText(Stdname.get(position));
            viewHolder.status.setText(Stdstatus.get(position));

            int status = statusArray.get(position) != null ? statusArray.get(position) : 0;
            switch (status){
                case 1:
                    viewHolder.status.setText("P");
                    viewHolder.status.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    viewHolder.status.setText("A");
                    viewHolder.status.setBackgroundColor(Color.RED);
                    break;
                case 3:
                    viewHolder.status.setText("L");
                    viewHolder.status.setBackgroundColor(Color.BLUE);
                    break;
                default:
                    viewHolder.status.setText("H");
                    viewHolder.status.setBackgroundColor(Color.YELLOW);
                    break;
            }

            viewHolder.status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int status1 = statusArray.get(position) != null ? statusArray.get(position) : 0;
                    if (status1 == 1) {
                        statusArray.put(position, 0);
                    } else if (status1 == 2) {
                        statusArray.put(position, 1);
                    } else if (status1 == 3) {
                        statusArray.put(position, 2);
                    } else {
                        statusArray.put(position, 3);
                    }

                    notifyDataSetChanged();
                }
            });
            return v;
        }
    }