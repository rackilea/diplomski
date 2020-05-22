button.setOnClickListener(new View.OnClickListener() 
{
        @Override
        public void onClick(View v) 
        {
            Intent intent = new Intent(MainActivity.this, blahdyblah.class);
            startActivity(intent);
        }
});