case R.id.newOffer:
    android.app.FragmentManager fm = getFragmentManager();
    android.app.FragmentTransaction ft = fm.beginTransaction();
    ft.replace(R.id.frame_container, new TipusNouProducte());
    ft.commit();
    return true;