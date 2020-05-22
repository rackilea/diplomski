final TextView tv = (TextView) findViewById(R.id.textViewTotal);
adapter.registerDataSetObserver(new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();

            double sum = 0;
            for (int i = 0 ; i < dataModels.size(); i++){
                sum = sum + dataModels.get(i).getPrize();
            }
            tv.setText("Total : " + String.valueOf(Math.round(sum)*100d/100d));
    }
});