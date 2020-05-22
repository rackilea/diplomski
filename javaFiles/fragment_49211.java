public static final string ARG_IMAGE_URL = "URL";

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this, Visor.class);
            intent.putExtras(ARG_IMAGE_URL, imagen.get(position))
            startActivity(intent);
        }
    });