Bundle bundle = new Bundle();
bundle.putString("titol", item.title);
android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
Fragment fragment = new DetallProducteOffer();
fragment.setArguments(bundle);
fm.beginTransaction()
.replace(R.id.frame_container, fragment).commit();