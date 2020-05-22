@Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Log.i("ID SENT: ",  toString().valueOf(i));
            mapsIntent = = new Intent(MainActivity.this, MapsActivity.class);
            mapsIntent.putExtra("number", i );
            startActivity( mapsIntent );
        }