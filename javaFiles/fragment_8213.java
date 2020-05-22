@Override
  public void onItemClick(AdapterView<?> pare, View view, int position, long id)     
  {
       Intent intent = new Intent(TodasAsCategorias.this, MapsActivity.class);
       intent.putExtra("data", listaPaises.get(position));
       startActivity(intent);
  }