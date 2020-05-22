Fragment newFragment = new NewLitter();
Bundle args = new Bundle();
args.putString("litter_name", your_data);
newFragment.setArguments(args);
// begin transaction
getFragmentManager().beginTransaction()
        .replace(R.id.container, newFragment)
        .commit();