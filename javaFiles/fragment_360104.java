btn.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {

  Intent intent = new Intent(getBaseContext(), FishInfo.class);
        intent.putExtra("typeName", num);
        intent.putExtra("typeInfo", twos);
        startActivity(intent);
  finish();
   }
  });