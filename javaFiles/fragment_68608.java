@Override
        public void onResponse(String response) {
            loading.dismiss();
            showJSON(response);
            saveSettings();
            Intent secondPage = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(secondPage);

        }
    },

 .
 .
 . 

    @Override
     public void onClick(View v) {
            getData();
     }
}