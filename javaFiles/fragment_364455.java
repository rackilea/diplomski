public void onBackPressed() {
    final FragmentManager fragmentManager = getSupportFragmentManager();
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
        drawerLayout.closeDrawer(GravityCompat.START);
    } else {
        if (fragmentManager.getBackStackEntryCount() - 1 == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogCustom);
            builder.setTitle("Sign out");
            builder.setMessage("Are you sure you want to sign out?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    firebaseAuth.signOut();
                    dialog.dismiss();
                    startActivity(new Intent(getApplicationContext(), WelcomeActivity.class));
                }
            });
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        } else {
            fragmentManager.popBackStack();
        }
    }
}