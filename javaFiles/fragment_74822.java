Fragment mF = getParentFragment();
// double check
if (mF instanceof  BenefitFragment) {
     getFragmentManager().beginTransaction()
                    .add(((BenefitFragment)getParentFragment()).getView().findViewById(R.id.benefitContainer).getId()
                            , new CorporateFragment())
                    .setCustomAnimations(R.anim.slide_in_left, R.anim.do_nothing)
                    .addToBackStack("benefit")
                    .commit();
}