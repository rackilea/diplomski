Bundle bundle = new Bundle();

bundle.putSerializable("keyName",names);

Intent i=new Intent(v.getContext(), SecondActivity.class);

i.putExtras(bundle);

startActivity(i);