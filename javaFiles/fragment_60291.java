public void onClick(View v) {
    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
    fragmentTransaction.hide(a);
    fragmentTransaction.hide(b);
    fragmentTransaction.commit();
 }