loginSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            loginSubmit.setVisibility(View.GONE);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.addToBackStack("LayoutFragment");
            ft.add(R.id.framelayoutfaqs, new LayoutFragment());
            ft.commit();
        }
    });

@Override
public void onBackPressed() {

    if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
        getSupportFragmentManager().popBackStackImmediate();
        loginSubmit.setVisibility(View.VISIBLE);
    } else
        super.onBackPressed();
}