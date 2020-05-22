for(int x = 1; x <= 15; x++){
  View view = LayoutInflater.from(this).inflate(R.layout.some_layout, appLayout, false);

  // Configure the items inside the view

  Button button1 = (Button)view.findViewById(R.id.button1);
  button1.setText("Button 1");
  button1.setOnClickListener(new View.OnClickListener() { ... });

  ...

  appLayout.addView(view); 
}