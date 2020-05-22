@Override
public void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
    android.app.FragmentTransaction ft = getActivity().getFragmentManager()
            .beginTransaction();
    ft.remove(fragment);
    ft.commit();
}

@Override
public void onDestroyView() {

    super.onDestroyView();

    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));
    android.app.FragmentTransaction ft = getActivity().getFragmentManager()
            .beginTransaction();
    ft.remove(fragment);
    ft.commit();

}