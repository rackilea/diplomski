FragmentManager fm = getSupportFragmentManager();

if (fm.findfragmentById(R.id.mainactivity) == null) {
     FragmentHomepage fragment = new FragmentHomepage ();
     fm.beginTransaction().add (R.id.mainactivity, fragment).commit();
}