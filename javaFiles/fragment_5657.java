String value=getIntent().getStringExtra("key");
Bundle bundle=new Bundle();
bundle.putString("key",value);
YourFragmentClass ob=new YourFragmentClass();
ob.setArguments(bundle);
getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.your_container_layout,ob).addToBackStack(null).commit();