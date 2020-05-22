existingPatient = new ExistingPatientFg();
Bundle bundle = new Bundle();
bundle.putString("title",cTitle);
existingPatient.setArguments(bundle);                 
trans = getFragmentManager().beginTransaction();
trans.replace(R.id.fragment_container, existingPatient);
trans.addToBackStack(null);
trans.commit();