TimeDateDialogFragment tddf = new TimeDateDialogFragment();

Bundle bundle = new Bundle();

bundle.put/*something*/(/* something else */);
bundle.putInt("hello", 5);

tddf.setArguments(bundle);

tddf.show(getFragmentManager(), "A");