public static CharacterFragment.newInstance(String name) {
    CharacterFragment fragment = new CharacterFragment();
    Bundle args = new Bundle();
    args.put("NAME_ARG", name);
    fragment.setArguments(args);
    return fragment;
}