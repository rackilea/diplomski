@Override
public Fragment getItem(int position) {
    CharacterFragment fragment = CharacterFragment.newInstance(name[position]);
    View rootView = fragment.getView();
    return fragment;
}