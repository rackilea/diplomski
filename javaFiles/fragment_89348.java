case R.id.newOffer:
    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.frame_container, new TipusNouProducte());
    ft.commit();
    return true;