imageView.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View view) {
            int[] values = new int[2]; 
            view.getLocationOnScreen(values);
            Log.d("X & Y",values[0]+" "+values[1]);
        }
    });