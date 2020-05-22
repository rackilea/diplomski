rm.getAllCourses(new VolleyCallbackOp() {
        public void onSuccess4(List<Course> cl) {
            String[] choices = new String[cl.size()];
            for (int a = 0; a < cl.size(); a++) {
                Course c = cl.get(a);
                choices[a] = c.toString();
            }

    aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, choices) {
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            View view = super.getDropDownView(position, convertView, parent);
            TextView tv = (TextView) view;
            if (position % 2 == 1) {
                tv.setBackgroundColor(Color.parseColor("#FFC9A3FF"));
            } else {
                tv.setBackgroundColor(Color.parseColor("#FFAF89E5"));
            }
            return view;
        }
    };
    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    //Setting the ArrayAdapter data on the Spinner
    cChoice.setAdapter(aa);
        }
    });