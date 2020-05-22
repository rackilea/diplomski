Bundle bundle = new Bundle();
bundle.putInt("battery", bat);
MyFragment fragment=new MyFragment();
fragment.setArguments(bundle);

FragmentTransaction ft = getFragmentManager().beginTransaction();
ft.add(R.id.fragment_container,fragment);
ft.commit();