btn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub

            result = new StringBuilder();
            for (int i = 0; i < arraylist.size(); i++) {
                if (adapter.mysparse.get(i) == true) {

                    result.append(arraylist.get(i).get(MainActivity.NAME));
                    result.append("\n");
                }

            }
            Intent n = new Intent(MainActivity.this, DisplayActivity.class);
            n.putExtra("buffer", result.toString());
            startActivity(n);
        }
    });