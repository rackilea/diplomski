private View.OnTouchListener spinnerOnTouch = new View.OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        selectedPosition = Integer.parseInt(v.getTag().toString());
        Some_obj obj = cells.get(selectedPosition);
        if (event.getAction() == MotionEvent.ACTION_UP) {
            adapter = null;
            if(obj.list == null) {
                adapter = new ArrayAdapter<String>(mContext, R.layout.spinner_cell, listFromActivity);
                spinner = (Spinner)v.findViewById(R.id.spinner);
                spinner.setAdapter(adapter);
                new GetSelectionsTask().execute();
            }
            else
            {
                adapter = new ArrayAdapter<String>(mContext, R.layout.spinner_cell, obj.list);
                spinner = (Spinner)v.findViewById(R.id.spinner);
                spinner.setAdapter(adapter);
            }
        }
        return false;
    }
};