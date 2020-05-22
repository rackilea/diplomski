arrivi fragobj = new arrivi();
FragmentTransaction transaction = getFragmentManager().beginTransaction();
Bundle bundle = new Bundle();
bundle.putString("edttext", "From Activity");
fragobj.setArguments(bundle)
transaction.replace(R.id.fragment_container, fragobj);
transaction.addToBackStack(null);
transaction.commit();