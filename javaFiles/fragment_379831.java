`@Override
        public void onClick(View v)

        {
            // TODO Auto-generated method stub
             Editable searchText = ev.getText();
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://stackoverflow.com/"));
            intent.putExtra(SearchManager.QUERY, ev.getText().toString()); 

            startActivity(intent); `